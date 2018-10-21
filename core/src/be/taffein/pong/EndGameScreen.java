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

public class EndGameScreen implements Screen {

    private Pong game;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private boolean won;

    public EndGameScreen(Pong game, boolean won) {
        this.game = game;
        this.batch = game.getBatch();
        this.shapeRenderer = game.getShapeRenderer();
        this.font = game.getFont();
        this.font.getData().setScale(1);
        this.won = won;

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

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        if (won) {
            drawWin();
        } else {
            drawLose();
        }

        shapeRenderer.end();

        batch.begin();
        font.draw(batch, "Press R to play again", 200, 60);
        font.draw(batch, "Press ESC to go back to the main menu", 200, 30);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            game.getScreen().dispose();
            game.setScreen(new GameScreen(game));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            game.getScreen().dispose();
            game.setScreen(new MainMenuScreen(game));
        }
    }

    private void drawWin() {
        // Y
        shapeRenderer.rect(130, 200, 20, 80);
        shapeRenderer.rect(110, 280, 20, 20);
        shapeRenderer.rect(90, 300, 20, 20);
        shapeRenderer.rect(150, 280, 20, 20);
        shapeRenderer.rect(170, 300, 20, 20);

        // O
        shapeRenderer.rect(230, 200, 40, 20);
        shapeRenderer.rect(210, 220, 20, 60);
        shapeRenderer.rect(270, 220, 20, 60);
        shapeRenderer.rect(230, 280, 40, 20);

        // U
        shapeRenderer.rect(330, 200, 60, 20);
        shapeRenderer.rect(310, 220, 20, 80);
        shapeRenderer.rect(370, 220, 20, 80);

        // W
        shapeRenderer.rect(490, 200, 80, 20);
        shapeRenderer.rect(470, 220, 20, 80);
        shapeRenderer.rect(510, 220, 20, 40);
        shapeRenderer.rect(550, 220, 20, 80);

        // I
        shapeRenderer.rect(590, 200, 20, 80);
        shapeRenderer.rect(590, 300, 20, 20);

        // N
        shapeRenderer.rect(630, 200, 20, 100);
        shapeRenderer.rect(650, 280, 40, 20);
        shapeRenderer.rect(690, 200, 20, 80);
    }

    private void drawLose() {
        // Y
        shapeRenderer.rect(90, 200, 20, 80);
        shapeRenderer.rect(70, 280, 20, 20);
        shapeRenderer.rect(50, 300, 20, 20);
        shapeRenderer.rect(110, 280, 20, 20);
        shapeRenderer.rect(130, 300, 20, 20);

        // O
        shapeRenderer.rect(190, 200, 40, 20);
        shapeRenderer.rect(170, 220, 20, 60);
        shapeRenderer.rect(230, 220, 20, 60);
        shapeRenderer.rect(190, 280, 40, 20);

        // U
        shapeRenderer.rect(290, 200, 60, 20);
        shapeRenderer.rect(270, 220, 20, 80);
        shapeRenderer.rect(330, 220, 20, 80);

        // L
        shapeRenderer.rect(430, 200, 20, 120);

        // O
        shapeRenderer.rect(490, 200, 40, 20);
        shapeRenderer.rect(470, 220, 20, 60);
        shapeRenderer.rect(530, 220, 20, 60);
        shapeRenderer.rect(490, 280, 40, 20);

        // S
        shapeRenderer.rect(570,200, 60, 20);
        shapeRenderer.rect(630,220, 20, 20);
        shapeRenderer.rect(590, 240, 40, 20);
        shapeRenderer.rect(570, 260, 20, 20);
        shapeRenderer.rect(590, 280, 60, 20);

        // E
        shapeRenderer.rect(690, 200, 60, 20);
        shapeRenderer.rect(670, 220, 20, 60);
        shapeRenderer.rect(690, 240, 40, 20);
        shapeRenderer.rect(690, 280, 60, 20);
        shapeRenderer.rect(730, 260, 20, 20);
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
