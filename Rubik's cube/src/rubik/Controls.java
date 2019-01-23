package rubik;

import java.util.Optional;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class Controls {
	
	private double mouseStartX, mouseStartY;
	private double startAngleX = 0;
	private double startAngleY = 0;
	private double startAngleZ = 0;
	private final DoubleProperty angleX = new SimpleDoubleProperty(0);
	private final DoubleProperty angleY = new SimpleDoubleProperty(0);
	private final DoubleProperty angleZ = new SimpleDoubleProperty(0);
	
	double scrollScaleX = 0.01; // ove tri promenljive se koriste za pomeranje kamere pri scroll-ovanju (zoom)
	double scrollScaleY = 0.01;
	double scrollScaleZ = 0.018;
	
	public Controls() {
		// TODO Auto-generated constructor stub
	}
	
	public void initControls(Group root, Scene scene, Stage stage, PerspectiveCamera camera) {
		Rotate rotateX, rotateY, rotateZ;

		root.getTransforms().addAll(rotateX = new Rotate(0, Rotate.X_AXIS), rotateY = new Rotate(0, Rotate.Y_AXIS),
				rotateZ = new Rotate(0, Rotate.Z_AXIS));
		rotateX.angleProperty().bind(angleX);
		rotateY.angleProperty().bind(angleY);
		rotateZ.angleProperty().bind(angleZ);

		scene.setOnMousePressed(event -> {
			mouseStartX = event.getSceneX();
			mouseStartY = event.getSceneY();
			startAngleX = angleX.get();
			startAngleY = angleY.get();
			startAngleZ = angleZ.get();
		});

		scene.setOnMouseDragged(event -> {
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				angleX.set(startAngleX - (mouseStartY - event.getSceneY()));
				angleY.set(startAngleY + mouseStartX - event.getSceneX());
			} else if (event.getButton().equals(MouseButton.SECONDARY)) {
				angleZ.set(startAngleZ + mouseStartX - event.getSceneX());
			}
		});

		scene.setOnKeyPressed(event -> {
			if (KeyCode.SPACE.equals(event.getCode()))
			{
				resetPosition();
			}
			else if (KeyCode.F12.equals(event.getCode()))
			{
				fullScreen(stage);
			}
			else if (KeyCode.ESCAPE.equals(event.getCode()))
			{
				quit();
			}
			else if (KeyCode.ENTER.equals(event.getCode()))
			{
				newGame();
			}
			else if (KeyCode.L.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Li");
						Moves.move = "Li";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("L");
						Moves.move = "L";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
			else if (KeyCode.R.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Ri");
						Moves.move = "Ri";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("R");
						Moves.move = "R";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
			else if (KeyCode.F.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Fi");
						Moves.move = "Fi";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("F");
						Moves.move = "F";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
			else if (KeyCode.B.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Bi");
						Moves.move = "Bi";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("B");
						Moves.move = "B";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
			else if (KeyCode.U.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Ui");
						Moves.move = "Ui";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("U");
						Moves.move = "U";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
			else if (KeyCode.D.equals(event.getCode()))
			{
				if(!Moves.moveFlag)
				{
					if(event.isShiftDown())
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("Di");
						Moves.move = "Di";
						//Moves.printState();
					}
					else
					{
						//Moves.printState();
						Moves.copy();
						Moves.turn("D");
						Moves.move = "D";
						//Moves.printState();
					}
					
					Moves.moveFlagOld = Moves.moveFlag;
					Moves.moveFlag = true;
				}
			}
		});

		stage.addEventHandler(ScrollEvent.SCROLL, event -> {
			double k = event.getDeltaY();
			root.translateXProperty().set(root.getTranslateX() + k * scrollScaleX);
			root.translateYProperty().set(root.getTranslateY() - k * scrollScaleY);
			root.translateZProperty().set(root.getTranslateZ() - k * scrollScaleZ);
		});
	}
	
	public void resetPosition() {
		angleX.set(0);
		angleY.set(0);
		angleZ.set(0);
	}
	
	public void newGame()
	{
		if(!Moves.isScrambling)
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Are you sure you want to start a new game?");
			alert.setContentText("You will scramble the cube and lose all your current progress.");
	
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Thread t = new Thread() {
				    public void run() {
				        Moves.Scramble(25);
				    }
				};
				t.start();
			}
		}
		else
		{
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information Dialog");
			alert.setHeaderText("You can't start a new game while the cube is scrambling.");	
			alert.showAndWait();
		}
	}
	
	public void scrambleControl()
	{
		if(!Moves.isScrambling)
		{
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Are you sure you want to scramble the cube?");
			alert.setContentText("You will lose all your current progress.");

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				Thread t = new Thread() {
				    public void run() {
				        Moves.Scramble(25);
				    }
				};
				t.start();
			}
		}
	}
	
	public void fullScreen(Stage primaryStage)
	{
		if (primaryStage.isFullScreen())
		{
			primaryStage.setFullScreen(false);
		}
		else
		{
			primaryStage.setFullScreen(true);
		}
	}
	
	public void quit()
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Are you sure you want to quit?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK){
			System.out.println("Application terminated by user.");
			System.exit(1);
		}
	}
}
