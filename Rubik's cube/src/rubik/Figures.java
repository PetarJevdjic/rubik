package rubik;

import java.util.HashMap;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Figures {
	
	public double scaleFactor = 5;
	public double offset = 0; // razmak izmedju kockica
	
	public HashMap<String, MeshView> meshes;

	public Figures() {
		// TODO Auto-generated constructor stub
	}

	public MeshView createCube(String name, double tX, double tY, double tZ) {
		TriangleMesh cube = new TriangleMesh();

		cube.getPoints().addAll(-0.5f, 0.5f, -0.5f, // A 0
				0.5f, 0.5f, -0.5f, // B 1
				0.5f, 0.5f, 0.5f, // C 2
				-0.5f, 0.5f, 0.5f, // D 3
				-0.5f, -0.5f, -0.5f, // E 4
				0.5f, -0.5f, -0.5f, // F 5
				0.5f, -0.5f, 0.5f, // G 6
				-0.5f, -0.5f, 0.5f // H 7
		);

		cube.getTexCoords().addAll(0.0f, 2f / 3, // 0
				0.0f, 1f / 3, // 1
				1f / 4, 1f / 3, // 2
				1f / 4, 0.0f, // 3
				1f / 2, 0.0f, // 4
				1f / 2, 1f / 3, // 5
				3f / 4, 1f / 3, // 6
				1.0f, 1f / 3, // 7
				1.0f, 2f / 3, // 8
				3f / 4, 2f / 3, // 9
				1f / 2, 2f / 3, // 10
				1f / 2, 1.0f, // 11
				1f / 4, 1.0f, // 12
				1f / 4, 2f / 3 // 13
		);

		cube.getFaces().addAll(
				// p0 t0 p1 t1 p2 t2
				0, 13, 5, 5, 4, 2, 0, 13, 1, 10, 5, 5, // front

				3, 9, 7, 6, 6, 7, 3, 9, 6, 7, 2, 8, // back

				0, 12, 3, 13, 2, 10, 0, 12, 2, 10, 1, 11, // bottom

				4, 2, 6, 4, 7, 3, 4, 2, 5, 5, 6, 4, // top

				0, 0, 4, 1, 7, 2, 0, 0, 7, 2, 3, 13, // left

				1, 10, 6, 6, 5, 5, 1, 10, 2, 9, 6, 6 // right

		);

		MeshView cubeMesh = new MeshView(cube);
		cubeMesh.setCullFace(CullFace.BACK);

		PhongMaterial material = new PhongMaterial();
		String slika = "file:Resources/Textures/" + name + ".png";
		material.setDiffuseMap(new Image(slika));
		material.setSpecularColor(Color.WHITE);
		material.setSpecularPower(20);

		cubeMesh.setMaterial(material);

		cubeMesh.getTransforms().add(new Translate(tX, tY, tZ));
		cubeMesh.getTransforms().add(new Scale(scaleFactor, scaleFactor, scaleFactor));

		return cubeMesh;
	}

	public HashMap<String, MeshView> createRubik() {
		meshes = new HashMap<String, MeshView>();;
		
		// FRONT
		MeshView mesh = createCube("F1", -scaleFactor - offset, -scaleFactor - offset, -scaleFactor - offset);
		meshes.put("F1", mesh);
		mesh = createCube("F2", 0, -scaleFactor - offset, -scaleFactor - offset);
		meshes.put("F2", mesh);
		mesh = createCube("F3", scaleFactor + offset, -scaleFactor - offset, -scaleFactor - offset);
		meshes.put("F3", mesh);
		mesh = createCube("F4", -scaleFactor - offset, 0, -scaleFactor - offset);
		meshes.put("F4", mesh);
		mesh = createCube("F5", 0, 0, -scaleFactor - offset);
		meshes.put("F5", mesh);
		mesh = createCube("F6", scaleFactor + offset, 0, -scaleFactor - offset);
		meshes.put("F6", mesh);
		mesh = createCube("F7", -scaleFactor - offset, scaleFactor + offset, -scaleFactor - offset);
		meshes.put("F7", mesh);
		mesh = createCube("F8", 0, scaleFactor + offset, -scaleFactor - offset);
		meshes.put("F8", mesh);
		mesh = createCube("F9", scaleFactor + offset, scaleFactor + offset, -scaleFactor - offset);
		meshes.put("F9", mesh);

		// STANDING
		mesh = createCube("S1", -scaleFactor - offset, -scaleFactor - offset, 0);
		meshes.put("S1", mesh);
		mesh = createCube("S2", 0, -scaleFactor - offset, 0);
		meshes.put("S2", mesh);
		mesh = createCube("S3", scaleFactor + offset, -scaleFactor - offset, 0);
		meshes.put("S3", mesh);
		mesh = createCube("S4", -scaleFactor - offset, 0, 0);
		meshes.put("S4", mesh);
		mesh = createCube("S5", 0, 0, 0);
		meshes.put("S5", mesh);
		mesh = createCube("S6", scaleFactor + offset, 0, 0);
		meshes.put("S6", mesh);
		mesh = createCube("S7", -scaleFactor - offset, scaleFactor + offset, 0);
		meshes.put("S7", mesh);
		mesh = createCube("S8", 0, scaleFactor + offset, 0);
		meshes.put("S8", mesh);
		mesh = createCube("S9", scaleFactor + offset, scaleFactor + offset, 0);
		meshes.put("S9", mesh);

		// BACK
		mesh = createCube("B1", -scaleFactor - offset, -scaleFactor - offset, scaleFactor + offset);
		meshes.put("B1", mesh);
		mesh = createCube("B2", 0, -scaleFactor - offset, scaleFactor + offset);
		meshes.put("B2", mesh);
		mesh = createCube("B3", scaleFactor + offset, -scaleFactor - offset, scaleFactor + offset);
		meshes.put("B3", mesh);
		mesh = createCube("B4", -scaleFactor - offset, 0, scaleFactor + offset);
		meshes.put("B4", mesh);
		mesh = createCube("B5", 0, 0, scaleFactor + offset);
		meshes.put("B5", mesh);
		mesh = createCube("B6", scaleFactor + offset, 0, scaleFactor + offset);
		meshes.put("B6", mesh);
		mesh = createCube("B7", -scaleFactor - offset, scaleFactor + offset, scaleFactor + offset);
		meshes.put("B7", mesh);
		mesh = createCube("B8", 0, scaleFactor + offset, scaleFactor + offset);
		meshes.put("B8", mesh);
		mesh = createCube("B9", scaleFactor + offset, scaleFactor + offset, scaleFactor + offset);
		meshes.put("B9", mesh);
		
		return meshes;
	}

	public Group buildAxes() {
		Group axes = new Group();

		double length = 6 * scaleFactor;
		double width = 4 * scaleFactor / 100d;
		double radius = 8 * scaleFactor / 100d;
		final PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.DARKRED);
		redMaterial.setSpecularColor(Color.RED);
		final PhongMaterial greenMaterial = new PhongMaterial();
		greenMaterial.setDiffuseColor(Color.DARKGREEN);
		greenMaterial.setSpecularColor(Color.GREEN);
		final PhongMaterial blueMaterial = new PhongMaterial();
		blueMaterial.setDiffuseColor(Color.DARKBLUE);
		blueMaterial.setSpecularColor(Color.BLUE);

		Sphere xSphere = new Sphere(radius);
		Sphere ySphere = new Sphere(radius);
		Sphere zSphere = new Sphere(radius);
		xSphere.setMaterial(redMaterial);
		ySphere.setMaterial(greenMaterial);
		zSphere.setMaterial(blueMaterial);

		xSphere.setTranslateX(3 * scaleFactor);
		ySphere.setTranslateY(-3 * scaleFactor);
		zSphere.setTranslateZ(-3 * scaleFactor);

		Cylinder xAxis = new Cylinder(width, length);
		xAxis.getTransforms().add(new Rotate(90, Rotate.Z_AXIS));
		Cylinder yAxis = new Cylinder(width, length);
		Cylinder zAxis = new Cylinder(width, length);
		zAxis.getTransforms().add(new Rotate(90, Rotate.X_AXIS));

		xAxis.setMaterial(redMaterial);
		yAxis.setMaterial(greenMaterial);
		zAxis.setMaterial(blueMaterial);

		axes.getChildren().addAll(xAxis, yAxis, zAxis);
		axes.getChildren().addAll(xSphere, ySphere, zSphere);

		return axes;
	}

}
