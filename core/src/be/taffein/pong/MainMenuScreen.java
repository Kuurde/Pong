package be.taffein.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MainMenuScreen implements Screen {

    private Pong game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;

    public MainMenuScreen(Pong game) {
        this.game = game;
        this.batch = game.getBatch();
        this.shapeRenderer = game.getShapeRenderer();
        this.font = game.getFont();
        this.font.getData().setScale(1);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        this.shapeRenderer.setColor(Color.WHITE);
        this.shapeRenderer.setProjectionMatrix(camera.combined);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        drawPong();

        batch.begin();
        font.draw(batch, "Press any key to start", 320, 30);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.getScreen().dispose();
            game.setScreen(new GameScreen(game));
        }
    }

    private void drawPong() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // P
        shapeRenderer.rect(55, 165, 30, 210);
        shapeRenderer.rect(85, 375, 90, 30);
        shapeRenderer.rect(85, 255, 90, 30);
        shapeRenderer.rect(175, 285, 30, 90);

        // O
        shapeRenderer.rect(235, 195, 30, 90);
        shapeRenderer.rect(355, 195, 30, 90);
        shapeRenderer.rect(265, 165, 90, 30);
        shapeRenderer.rect(265, 285, 90, 30);

        // N
        shapeRenderer.rect(415, 165, 30, 150);
        shapeRenderer.rect(445, 255, 30, 30);
        shapeRenderer.rect(475, 285, 60, 30);
        shapeRenderer.rect(535, 165, 30, 120);

        // G
        shapeRenderer.rect(595, 105, 60, 30);
        shapeRenderer.rect(625, 75, 90, 30);
        shapeRenderer.rect(595, 195, 30, 90);
        shapeRenderer.rect(625, 165, 90, 30);
        shapeRenderer.rect(625, 285, 90, 30);
        shapeRenderer.rect(715, 105, 30, 180);

        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
