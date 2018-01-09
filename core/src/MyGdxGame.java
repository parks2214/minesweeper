package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    Texture imgMine, imgGO;
    Sprite sprBad, sprGO;
    int nY = 200, nX = 200, nBackground = 0;
    ShapeRenderer shape;

    @Override
    public void create() {
        batch = new SpriteBatch();
        imgMine = new Texture("Mine.png");
        imgGO = new Texture("Gameover.png");
        sprBad = new Sprite(imgMine);
        sprBad.setPosition(nX, nY);
        sprGO = new Sprite(imgGO);
        sprGO.setPosition(0, 400);
        shape = new ShapeRenderer();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin(); //everything is drawn and used
        if (nBackground == 1) {
            sprBad.draw(batch);
            sprGO.draw(batch);
        }
        batch.end();
        if (nBackground == 0) {
            shape.begin(ShapeType.Filled);
            shape.setColor(Color.RED);
            shape.rect(sprBad.getBoundingRectangle().x, sprBad.getBoundingRectangle().y,
                    sprBad.getBoundingRectangle().width, sprBad.getBoundingRectangle().height);
            shape.end();
        }
        

        click();
    }

    @Override
    public void dispose() {
        batch.dispose();
        imgMine.dispose();
    }

    public void click() {
        if (Gdx.input.isTouched()) {
            System.out.println(Gdx.input.getX() + " " + (Gdx.graphics.getHeight() - Gdx.input.getY()));
            if (sprBad.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY())) {
                nBackground = 1;
                // System.out.println("Gimme yo fakking money");
            }
        }
    }
}
