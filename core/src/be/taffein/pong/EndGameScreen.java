package be.taffein.pong;

import com.badlogic.gdx.Gdx;
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

        drawYou();

        if (won) {
            drawWin();
        } else {
            drawLose();
        }

        shapeRenderer.end();
    }

    private void drawYou() {
        // Y
        shapeRenderer.rect(40, 0, 20, 80);
        shapeRenderer.rect(20, 80, 20, 20);
        shapeRenderer.rect(0, 100, 20, 20);
        shapeRenderer.rect(60, 80, 20, 20);
        shapeRenderer.rect(80, 100, 20, 20);

        // O
        shapeRenderer.rect(140, 0, 40, 20);
        shapeRenderer.rect(120, 20, 20, 60);
        shapeRenderer.rect(180, 20, 20, 60);
        shapeRenderer.rect(140, 80, 40, 20);

        // U
        shapeRenderer.rect(240, 0, 60, 20);
        shapeRenderer.rect(220, 20, 20, 80);
        shapeRenderer.rect(280, 20, 20, 80);
    }

    private void drawWin() {
        // W
        shapeRenderer.rect(400, 0, 80, 20);
        shapeRenderer.rect(380, 20, 20, 80);
        shapeRenderer.rect(420, 20, 20, 40);
        shapeRenderer.rect(460, 20, 20, 80);

        // I
        shapeRenderer.rect(500, 0, 20, 80);
        shapeRenderer.rect(500, 100, 20, 20);

        // N
        shapeRenderer.rect(540, 0, 20, 100);
        shapeRenderer.rect(560, 80, 40, 20);
        shapeRenderer.rect(600, 0, 20, 80);
    }

    private void drawLose() {
        // L
        shapeRenderer.rect(380, 0, 20, 120);

        // O
        shapeRenderer.rect(440, 0, 40, 20);
        shapeRenderer.rect(420, 20, 20, 60);
        shapeRenderer.rect(480, 20, 20, 60);
        shapeRenderer.rect(440, 80, 40, 20);

        // S
        shapeRenderer.rect(520,0, 60, 20);
        shapeRenderer.rect(580,20, 20, 20);
        shapeRenderer.rect(540, 40, 40, 20);
        shapeRenderer.rect(520, 60, 20, 20);
        shapeRenderer.rect(540, 80, 60, 20);

        // E
        shapeRenderer.rect(640, 0, 60, 20);
        shapeRenderer.rect(620, 20, 20, 60);
        shapeRenderer.rect(640, 40, 40, 20);
        shapeRenderer.rect(640, 80, 60, 20);
        shapeRenderer.rect(680, 60, 20, 20);
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
