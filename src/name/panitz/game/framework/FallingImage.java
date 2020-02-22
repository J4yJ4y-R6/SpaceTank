package name.panitz.game.framework;

public class FallingImage<I> extends ImageObject<I> {
	static double G = 9.81;
	double v0;
	int t = 0;

	public boolean isJumping = false;

	public FallingImage(String imageFileName, Vertex corner, Vertex movement) {
		super(imageFileName, corner, movement);
	}

	public void stop() {
		getPos().move(getVelocity().mult(-1.1));
		getVelocity().x = 0;
		getVelocity().y = 0;
		isJumping = false;
	}

	public void restart() {
		double oldX = getVelocity().x;
		getPos().move(getVelocity().mult(-1.1));
		getVelocity().x = -oldX;
		getVelocity().y = 0;
		isJumping = false;
	}

	
	public void left() {
		if (!isJumping) {
			getVelocity().x = -1;
		}
	}

	public void right() {
		if (!isJumping) {
			getVelocity().x = +1;
		}
	}

	public void jump() {
		if (!isJumping) {
			startJump(-3.5);
		}
	}

	public void startJump(double v0) {
		isJumping = true;
		this.v0 = v0;
		t = 0;
	}

	@Override
	public void move() {
		if (isJumping) {
			t++;
			double v = v0 + G * t / 200;
			getVelocity().y = v;
		}
		super.move();
	}
}
