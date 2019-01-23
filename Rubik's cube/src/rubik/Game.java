package rubik;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.metal.MetalPopupMenuSeparatorUI;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.AmbientLight;
import javafx.scene.DepthTest;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.MeshView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Game extends Application {
	
	BorderPane UI;
	Text info;
	
	Figures f = new Figures();
	Controls c = new Controls();
	
	HashMap<String, MeshView> meshes;

	private double timeStart = Double.NaN;
	public HashMap<MeshView, Double> kockice = new HashMap<MeshView, Double>();
	
	private double epsilon = 0.01; // obezbedjuje da se stranica kocke ne izrotira za vise od 90 stepeni pri potezu
	
	List<Double> rotationDif = new ArrayList<Double>();

	private double gameStart = 0;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	AnimationTimer animation = new AnimationTimer() {
		@Override
		public void handle(long now) {
			double timeNow = now * 1e-9;
			
			if(Moves.newGame)
			{
				gameStart = timeNow;
				Moves.newGame = false;
			}
			
			if(Moves.moveFlag && !Moves.moveFlagOld) //znaci da pocinje novi potez, promenio se flag sa false na true, sacuvaj sve sto je potrebno
			{
				MeshView mesh;
				timeStart = timeNow; // cuva se pocetno vreme rotacije
				kockice.clear();
				
				if(Moves.move.contains("U"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Y_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[1][0][1]);
					mesh.setRotationAxis(Rotate.Y_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);
				}
				else if(Moves.move.contains("D"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Y_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[1][2][1]);
					mesh.setRotationAxis(Rotate.Y_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);
				}
				else if(Moves.move.contains("L"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.X_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[1][1][0]);
					mesh.setRotationAxis(Rotate.X_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);
				}
				else if(Moves.move.contains("R"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.X_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[1][1][2]);
					mesh.setRotationAxis(Rotate.X_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);
				}
				else if(Moves.move.contains("F"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Z_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[0][1][1]);
					mesh.setRotationAxis(Rotate.Z_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);
				}
				else if(Moves.move.contains("B"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
								if(!Moves.rubikOld[i][j][k].equals(Moves.rubik[i][j][k]))
								{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Z_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
								}
							}
					mesh = meshes.get(Moves.rubik[2][1][1]);
					mesh.setRotationAxis(Rotate.Z_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);

				}
				else if(Moves.move.contains("X"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.X_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
							}
				}
				else if(Moves.move.contains("Y"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Y_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
							}
				}
				else if(Moves.move.contains("Z"))
				{
					rotationDif.clear();
					
					for(int i=0; i<3; i++)
						for(int j=0; j<3; j++)
							for(int k=0; k<3; k++)
							{
									mesh = meshes.get(Moves.rubik[i][j][k]);
									mesh.setRotationAxis(Rotate.Z_AXIS);
									kockice.put(mesh, mesh.getRotate());
									
									rotationDif.add(0.0);
							}
				}
					
				Moves.moveFlagOld = true; //da ne bi vise bili isti, posto je inicijalizacija gotova
			}
			
			double time = timeNow - timeStart;     // Vreme proteklo od starta animacije
			double t = time % 1;
			
			double k = Math.sin(t/0.5 * Math.PI/2); // ease out sine
			
			if(Moves.moveFlag)
			{
				if(Moves.move.contains("U"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Y_AXIS);
						
						double d = s;
						if(Moves.move.equals("U")) d += 90.0f;
						else if(Moves.move.equals("Ui")) d -= 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});						
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = -90.0;
							else r = 90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Y_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("D"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Y_AXIS);
						
						double d = s;
						if(Moves.move.equals("D")) d -= 90.0f;
						else if(Moves.move.equals("Di")) d += 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = 90.0;
							else r = -90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Y_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("L"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.X_AXIS);
						
						double d = s;
						if(Moves.move.equals("L")) d += 90.0f;
						else if(Moves.move.equals("Li")) d -= 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = -90.0;
							else r = 90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.X_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("R"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.X_AXIS);
						
						double d = s;
						if(Moves.move.equals("R")) d -= 90.0f;
						else if(Moves.move.equals("Ri")) d += 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = 90.0;
							else r = -90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.X_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
//	                    System.out.println("r = " + r + " , rotationDif = " + rotationDif.get(0));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("F"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Z_AXIS);
						
						double d = s;
						if(Moves.move.equals("F")) d += 90.0f;
						else if(Moves.move.equals("Fi")) d -= 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = -90.0;
							else r = 90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Z_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("B"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Z_AXIS);
						
						double d = s;
						if(Moves.move.equals("B")) d -= 90.0f;
						else if(Moves.move.equals("Bi")) d += 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});						
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = 90.0;
							else r = -90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Z_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("X"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.X_AXIS);
						
						double d = s;
						if(Moves.move.equals("X")) d -= 90.0f;
						else if(Moves.move.equals("Xi")) d += 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});						
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = 90.0;
							else r = -90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.X_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("Y"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Y_AXIS);
						
						double d = s;
						if(Moves.move.equals("Y")) d += 90.0f;
						else if(Moves.move.equals("Yi")) d -= 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});						
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = -90.0;
							else r = 90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Y_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
				else if(Moves.move.contains("Z"))
				{
					int br = 0;
					
					for (Map.Entry<MeshView, Double> entry : kockice.entrySet()) 
					{
						MeshView mesh = entry.getKey();
						Double s = entry.getValue();
						
						mesh.setRotationAxis(Rotate.Z_AXIS);
						
						double d = s;
						if(Moves.move.equals("Z")) d += 90.0f;
						else if(Moves.move.equals("Zi")) d -= 90.0f;
						double r = s*(1 - k) + (d * k);
						if((Math.abs(r-d) < epsilon) || time>0.49)
						{
							Moves.moveFlagOld = false;
							Moves.moveFlag = false;
						}
						ObservableList<Transform> x = mesh.getTransforms();
						Affine a = new Affine();
						x.forEach(n -> {
							a.append(n);
						});
						if(!Moves.moveFlag)
						{
							if(Moves.move.contains("i")) r = -90.0;
							else r = 90.0;
						}
						a.prepend(new Rotate(r-rotationDif.get(br), Rotate.Z_AXIS));
	                    rotationDif.set(br, rotationDif.get(br) + (r-rotationDif.get(br)));
	                    mesh.getTransforms().setAll(a);
	                    br++;
					}
				}
			}
			
			if(Moves.gameInProgress || Moves.gameInProgressOld) // u koliko je igra u toku ispisi proteklo vreme od starta i broj poteza
			{
				String text;
				int min, sec, remaining;
				double gameTime = timeNow - gameStart;
				min = (int)(gameTime/60);
				sec = (int)((gameTime%60)/1);
				remaining = (int)(((gameTime%60)%1)*10);
				
				if(sec<10) text = String.format("\n   Time = %d:0%d:%d\n   Moves = %d", min, sec, remaining, Moves.movesCount);
					else text = String.format("\n   Time = %d:%d:%d\n   Moves = %d", min, sec, remaining, Moves.movesCount);
				
				if(Moves.gameInProgressOld) // ovaj deo se izvrsava ako je zaustavljeno vreme, odnosno doslo je do kraja igre
				{
					Moves.gameInProgressOld = false;
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText("Congratulations, you have successfully solved the Rubik's cube!");
					alert.show();
				}
				
				info.setText(text);
//				System.out.println(text);
			}
		}
	};

	@Override
	public void start(Stage primaryStage) throws Exception {

		AmbientLight lightA = new AmbientLight(Color.hsb(0, 0, 0.4));

		PointLight lightP1 = new javafx.scene.PointLight(Color.hsb(0, 0, 0.8));
		lightP1.getTransforms().add(new Translate(-1000, -1000, -1000));

		PointLight lightP2 = new javafx.scene.PointLight(Color.hsb(0, 0, 0.8));
		lightP2.getTransforms().add(new Translate(1000, -1000, -1000));

		Group root = new Group(lightA, lightP1);

		meshes = f.createRubik();

		Group model = new Group(f.buildAxes());

		model.getChildren().addAll(meshes.values());

		root.getChildren().add(model);

		PerspectiveCamera camera = new PerspectiveCamera(true);

		camera.setTranslateX(7 * f.scaleFactor);
		camera.setTranslateY(-8 * f.scaleFactor);
		camera.setTranslateZ(-12 * f.scaleFactor);

		camera.getTransforms().addAll(new Rotate(-30, Rotate.Y_AXIS), new Rotate(-30, Rotate.X_AXIS));

		camera.setFieldOfView(30);
		camera.setFarClip(10000);
		camera.setNearClip(1);

		SubScene main = new SubScene(root, 800, 600, true, SceneAntialiasing.BALANCED);
		main.setCamera(camera);

		// pravljenje UI sa padajucim menijem i informacijama o toku igre
		Menu file = new Menu("File");
		
		MenuItem option1 = new MenuItem("New Game (Enter)");
		MenuItem option2 = new MenuItem("Reset rotation (Space)");
		MenuItem option3 = new MenuItem("Fullscreen (F12)");
		MenuItem option4 = new MenuItem("Help");
		MenuItem option5 = new MenuItem("Exit game (Esc)");
		
		option1.setOnAction(e -> {
			c.newGame();
		});
		
		option2.setOnAction(e -> {
			c.resetPosition();
		});
		
		option3.setOnAction(e -> {
			c.fullScreen(primaryStage);
		});
		
		option4.setOnAction(e -> {
			c.help();
		});
		
		option5.setOnAction(e -> {
			c.quit();
		});
		
		SeparatorMenuItem separator = new SeparatorMenuItem();
		
		file.getItems().addAll(option1, option2, option3, new SeparatorMenuItem(), option4, new SeparatorMenuItem(), option5);
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(file);
		
		info = new Text("\n   Time = 0:00:00\n   Moves = 0");
		info.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		info.setFill(Color.WHITE);
		
		UI = new BorderPane();
		UI.setTop(menuBar);
		UI.setBottom(info);
		UI.setPrefWidth(1920);
		
		// zbog UI sam morao da koristim subScene, a posto Gradient pozadine ne funkcionisu sa SubScene, ovo je work around
		// sa postavljanjem gradient pozadine na AnchorPane u koji se dodaju pod scene
		AnchorPane pane = new AnchorPane();
		pane.setDepthTest(DepthTest.ENABLE);
		pane.getChildren().addAll(main, UI);
		final Scene scene = new Scene(pane, 800, 600, true, SceneAntialiasing.BALANCED);
		RadialGradient radialGradient = new RadialGradient(225, 0.85, 300, 300, 500, false, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0f, Color.BLUE), new Stop(1f, Color.LIGHTBLUE) });
		pane.setBackground(new Background(new BackgroundFill(radialGradient, CornerRadii.EMPTY, Insets.EMPTY)));
		
		main.heightProperty().bind(pane.heightProperty());
		main.widthProperty().bind(pane.widthProperty());
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Rubik's cube");
		primaryStage.show();

		c.initControls(model, scene, primaryStage, camera);
		
		animation.start();		
	}
	
	public static void main(String[] args) {
		Application.launch();
	}

}
