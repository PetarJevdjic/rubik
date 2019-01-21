package rubik;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.MeshView;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Game extends Application {
	
	Figures f = new Figures();
	Controls c = new Controls();
	
	HashMap<String, MeshView> meshes;

	private double timeStart = Double.NaN;
	public HashMap<MeshView, Double> kockice = new HashMap<MeshView, Double>();
	
	private double epsilon = 0.01; // obezbedjuje da se stranica kocke ne izrotira za vise od 90 stepeni pri potezu
	
	List<Double> rotationDif = new ArrayList<Double>();

	public Game() {
		// TODO Auto-generated constructor stub
	}
	
	AnimationTimer animation = new AnimationTimer() {
		@Override
		public void handle(long now) {
			double timeNow = now * 1e-9;
			
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
					mesh = meshes.get("S2");
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
					mesh = meshes.get("S8");
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
					mesh = meshes.get("S4");
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
					mesh = meshes.get("S6");
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
					mesh = meshes.get("F5");
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
					mesh = meshes.get("B5");
					mesh.setRotationAxis(Rotate.Z_AXIS);
					kockice.put(mesh, mesh.getRotate());
					
					rotationDif.add(0.0);

				}
					
				Moves.moveFlagOld = true; //da ne bi vise bili isti, posto je inicijalizacija gotova
			}
			
			double time = timeNow - timeStart;     // Vreme proteklo od starta animacije
			double t = time % 1;
			
			double k = Math.sin(t * Math.PI/2); // ease out sine
			
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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
						if((Math.abs(r-d) < epsilon) || time>0.99)
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

		Scene scene = new Scene(root, 800, 600, true, SceneAntialiasing.BALANCED);
		scene.setFill(new RadialGradient(225, 0.85, 300, 300, 500, false, CycleMethod.NO_CYCLE,
				new Stop[] { new Stop(0f, Color.BLUE), new Stop(1f, Color.LIGHTBLUE) }));
		scene.setCamera(camera);

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
