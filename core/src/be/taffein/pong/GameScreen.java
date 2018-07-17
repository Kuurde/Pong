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
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen {
    private static final int PLAYER_SPEED = 200;
    private static final int BALL_SPEED = 300;

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont font;
    private OrthographicCamera camera;

    private Rectangle playerOne;
    private Rectangle playerTwo;
    private Rectangle ball;
    private float directionX = -1;
    private float directionY = -1;
    private int playerOneScore;
    private int playerTwoScore;

    public GameScreen(SpriteBatch batch, ShapeRenderer shapeRenderer, BitmapFont font) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.font = font;
        this.font.setColor(Color.WHITE);
        this.font.getData().setScale(2);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        this.shapeRenderer.setColor(Color.WHITE);
        this.shapeRenderer.setProjectionMatrix(camera.combined);

        initGame();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        renderShapes();
        handleInput();
        moveBall();
        controlPlayerTwo();
        drawScore();
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

    private void initGame() {
        playerOne = new Rectangle(20, 480 / 2 - 80 / 2, 20, 80);
        playerTwo = new Rectangle(760, 480 / 2 - 80 / 2, 20, 80);
        ball = new Rectangle(800 / 2 - 5, 480 / 2 - 5, 10, 10);
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    private void renderShapes() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(playerOne.x, playerOne.y, playerOne.width, playerOne.height);
        shapeRenderer.rect(playerTwo.x, playerTwo.y, playerTwo.width, playerTwo.height);
        shapeRenderer.rect(ball.x, ball.y, ball.width, ball.height);

        float lineX = 800 / 2 -4;
        for (int i = 0; i < 480; i = i + 15) {
            shapeRenderer.rect(lineX, i, 8, 8);
        }

        shapeRenderer.end();
    }

    private void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            playerOne.y += 200 * Gdx.graphics.getDeltaTime();
            if (playerOne.y > 400) {
                playerOne.y = 400;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            playerOne.y -= PLAYER_SPEED * Gdx.graphics.getDeltaTime();
            if (playerOne.y < 0) {
                playerOne.y = 0;
            }
        }
    }

    private void moveBall() {
        ball.x += directionX * BALL_SPEED * Gdx.graphics.getDeltaTime();
        ball.y += directionY * BALL_SPEED * Gdx.graphics.getDeltaTime();

        if (ball.overlaps(playerOne)) {
            directionX = 1;
        }

        if (ball.overlaps(playerTwo)) {
            directionX = -1;
        }

        if (ball.y < 0) {
            directionY = 1;
        }

        if (ball.y > 480) {
            directionY = -1;
        }

        if (ball.x < 0) {
            playerTwoScore++;
            ball.setPosition(800 / 2 - 5, 480 / 2 - 5);
        }

        if (ball.x > 800) {
            playerOneScore++;
            ball.setPosition(800 / 2 - 5, 480 / 2 - 5);
        }
    }

    private void controlPlayerTwo() {
        if (playerTwo.y > ball.y) {
            playerTwo.y -= PLAYER_SPEED * Gdx.graphics.getDeltaTime();
        }

        if (playerTwo.y < ball.y) {
            playerTwo.y += PLAYER_SPEED * Gdx.graphics.getDeltaTime();
        }
    }

    private void drawScore() {
        batch.begin();

        font.draw(batch, String.valueOf(playerOneScore), 350, 450);
        font.draw(batch, String.valueOf(playerTwoScore), 430, 450);

        batch.end();
    }
}
