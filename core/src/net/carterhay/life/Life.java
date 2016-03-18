package net.carterhay.life;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.Keys;

public class Life extends ApplicationAdapter {
	SpriteBatch batch;
	Texture tile;
	Texture activeTile;
  LifeBoard board;
  float timer;
  enum State {RUNNING, PAUSED}
  State state;
  int cellX, cellY;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.tile = new Texture("Tile.jpg");
		this.activeTile = new Texture("ActiveTile.jpg");
    this.cellX = Gdx.graphics.getWidth()/10;
    this.cellY = Gdx.graphics.getHeight()/10;
    System.out.println("x " + cellX + " Y " + cellY);
    this.board = new LifeBoard(cellX, cellY);
    this.timer = 0;
    this.state = State.RUNNING;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
    for (int y = 0; y < cellY; y++) {
      for (int x = 0; x < cellX; x++) {
        if (this.board.getBoard()[x][y]) {
          this.batch.draw(activeTile, 10*x, 10*y);
        } else {
          this.batch.draw(tile, 10*x, 10*y);
        }
      }
    }
		this.batch.end();

    switch (state) {
      case RUNNING:
        this.timer += Gdx.graphics.getDeltaTime();
        if (timer >= .5) {
          timer -= .5;
          this.board.update();
        }
        break;

      case PAUSED:
        break;

      default:
        break;

    }

    if (Gdx.input.isTouched()) {
      int x = Gdx.input.getX()/10;
      int y = (this.cellY-(Gdx.input.getY()/10))-1;
      //System.out.println("Clicked! x: " + x + ", y: " + y);
      if (x >= 0 && x < cellX && y >= 0 && y < cellY) {
        this.board.setOn(x,y);
      }
    }

    if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
      if (this.state == State.RUNNING) {
        this.state = State.PAUSED;
      } else {
        this.state = State.RUNNING;
      }
    }
	}
}
