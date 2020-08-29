import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;

//Create a basic shape animation application in Javafx
public class Animation extends Application{
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		
		///set the root of the stage to be in border pane
		BorderPane root = new BorderPane();
		
		//grid layout for the shape
		GridPane gp = new GridPane();
		gp.setHgap(5);
		gp.setVgap(5);
		gp.setGridLinesVisible(true);
		
		Label lbSelector = new Label();
		
		//Create a menu for each shape
		Menu sphereMenu = new Menu("Sphere Menu");
		Menu cylinderMenu = new Menu("Cylinder Menu");
		Menu boxMenu = new Menu("Box Menu");
		Menu polygonMenu = new Menu("Polygon Menu");
		
		//create a menu bar and add each menu
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(sphereMenu);
		menuBar.getMenus().add(cylinderMenu);
		menuBar.getMenus().add(boxMenu);
		menuBar.getMenus().add(polygonMenu);
		
		//set the menu bar to a Anchor pane layout
		AnchorPane anchorP = new AnchorPane();
		anchorP.getChildren().addAll(menuBar, lbSelector);
		
		//set the menu bar to be the top of the border pane
		root.setTop(anchorP);
		
		//create a sub menu inside the main menu
		MenuItem menu1Item1 = new MenuItem("Rotate Transition");
		sphereMenu.getItems().add(menu1Item1);
		menu1Item1.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to rotate a sphere when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				RotateTransition sphereRotate = new RotateTransition();
				sphereRotate.setDuration(Duration.millis(1000));
				sphereRotate.setNode(gp.getChildren().get(1));
				sphereRotate.setByAngle(45);
				sphereRotate.setCycleCount(4);
				sphereRotate.setAutoReverse(true);
				sphereRotate.play();	
			}
		});
		
		//a separate rotation menu for the sequential transition
		RotateTransition rotateTrans = new RotateTransition();
		rotateTrans.setDuration(Duration.millis(1000));
		rotateTrans.setByAngle(45);
		rotateTrans.setCycleCount(4);
		rotateTrans.setAutoReverse(true);
		rotateTrans.play();	
		
		//create a sub menu inside the main menu
		MenuItem menu1Item2 = new MenuItem("Scale Transition");
		sphereMenu.getItems().add(menu1Item2);
		menu1Item2.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to scale size a sphere when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				ScaleTransition sphereScale = new ScaleTransition();
				sphereScale.setDuration(Duration.millis(1000));
				sphereScale.setNode(gp.getChildren().get(1));
				sphereScale.setByY(-.2);
				sphereScale.setByX(-.2);
				sphereScale.setCycleCount(6);
				sphereScale.setAutoReverse(true);
				sphereScale.play();
				
			}
		});
		
		//a separate scale transition for sequential transition
		ScaleTransition scaleTrans = new ScaleTransition();
		scaleTrans.setDuration(Duration.millis(1000));
		scaleTrans.setByY(-.2);
		scaleTrans.setByX(-.2);
		scaleTrans.setCycleCount(6);
		scaleTrans.setAutoReverse(true);
		scaleTrans.play();
		
		//create a sub menu inside the main menu
		MenuItem menu1Item3 = new MenuItem("Sequential Transition");
		sphereMenu.getItems().add(menu1Item3);
		menu1Item3.setOnAction(new EventHandler<ActionEvent>() {
			
			//allow user the play all the transition from the menu in order 
			@Override
			public void handle(ActionEvent event) {
																	//children, rotation, scale rotation
				SequentialTransition seqT =  new SequentialTransition(gp.getChildren().get(1), rotateTrans, scaleTrans);
				seqT.play();
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu2Item1 = new MenuItem("Rotate Transition");
		cylinderMenu.getItems().add(menu2Item1);
		menu2Item1.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to rotate a cylinder when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				RotateTransition rotate = new RotateTransition();
				rotate.setDuration(Duration.millis(1000));
				rotate.setNode(gp.getChildren().get(2));
				rotate.setByAngle(45);
				rotate.setCycleCount(6);
				rotate.setAutoReverse(true);
				rotate.play();	
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu2Item2 = new MenuItem("Scale Transition");
		cylinderMenu.getItems().add(menu2Item2);
		menu2Item2.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to scale size a cylinder when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				ScaleTransition scaleTrans = new ScaleTransition();
				scaleTrans.setDuration(Duration.millis(1000));
				scaleTrans.setNode(gp.getChildren().get(2));
				scaleTrans.setByY(-.2);
				scaleTrans.setByX(-.2);
				scaleTrans.setCycleCount(6);
				scaleTrans.setAutoReverse(true);
				scaleTrans.play();
				
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu2Item3 = new MenuItem("Sequential Transition");
		cylinderMenu.getItems().add(menu2Item3);
		menu2Item3.setOnAction(new EventHandler<ActionEvent>() {
			
			//allow user the play all the transition from the menu in order
			@Override
			public void handle(ActionEvent event) {
				SequentialTransition seqT =  new SequentialTransition(gp.getChildren().get(2), rotateTrans, scaleTrans);
				seqT.play();
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu3Item1 = new MenuItem("Rotate Transition");
		boxMenu.getItems().add(menu3Item1);
		menu3Item1.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to rotate a box when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				RotateTransition rotate = new RotateTransition();
				rotate.setDuration(Duration.millis(1000));
				rotate.setNode(gp.getChildren().get(3));
				rotate.setByAngle(45);
				rotate.setCycleCount(6);
				rotate.setAutoReverse(true);
				rotate.play();	
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu3Item2 = new MenuItem("Scale Transition");
		boxMenu.getItems().add(menu3Item2);
		menu3Item2.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to scale size a box when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				ScaleTransition scaleTrans = new ScaleTransition();
				scaleTrans.setDuration(Duration.millis(1000));
				scaleTrans.setNode(gp.getChildren().get(3));
				scaleTrans.setByY(-.2);
				scaleTrans.setByX(-.2);
				scaleTrans.setCycleCount(6);
				scaleTrans.setAutoReverse(true);
				scaleTrans.play();
				
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu3Item3 = new MenuItem("Sequential Transition");
		boxMenu.getItems().add(menu3Item3);
		menu3Item3.setOnAction(new EventHandler<ActionEvent>() {
			
			//allow user the play all the transition from the menu in order
			@Override
			public void handle(ActionEvent event) {
				SequentialTransition seqT =  new SequentialTransition(gp.getChildren().get(3), rotateTrans, scaleTrans);
				seqT.play();
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu4Item1 = new MenuItem("Rotate Transition");
		polygonMenu.getItems().add(menu4Item1);
		menu4Item1.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to rotate a box when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				RotateTransition rotate = new RotateTransition();
				rotate.setDuration(Duration.millis(1000));
				rotate.setNode(gp.getChildren().get(4));
				rotate.setByAngle(360);
				rotate.setCycleCount(6);
				rotate.setAutoReverse(true);
				rotate.play();
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu4Item2 = new MenuItem("Scale Transition");
		polygonMenu.getItems().add(menu4Item2);
		menu4Item2.setOnAction(new EventHandler<ActionEvent>() {
			
			//create event that allow user to scale size a polygon when the specific menu is clicked
			@Override
			public void handle(ActionEvent event) {
				ScaleTransition scaleTrans = new ScaleTransition();
				scaleTrans.setDuration(Duration.millis(1000));
				scaleTrans.setNode(gp.getChildren().get(4));
				scaleTrans.setByY(-.2);
				scaleTrans.setByX(-.2);
				scaleTrans.setCycleCount(6);
				scaleTrans.setAutoReverse(true);
				scaleTrans.play();
				
			}
		});
		
		//create a sub menu inside the main menu
		MenuItem menu4Item3 = new MenuItem("Fade Transition");
		polygonMenu.getItems().add(menu4Item3);
		menu4Item3.setOnAction(new EventHandler<ActionEvent>() {
			
			//allow user the fade transition a polygon when the menu is clicked
			@Override
			public void handle(ActionEvent event) {
				FadeTransition fade = new FadeTransition();
				fade.setDuration(Duration.millis(1000));
				fade.setNode(gp.getChildren().get(4));
				fade.setFromValue(1.0);
				fade.setToValue(3.0);
				fade.setCycleCount(6);
				fade.setAutoReverse(true);
				fade.play();
				
			}
		});
		
		//a separate fade transition for sequential transition
		FadeTransition fadeTrans = new FadeTransition();
		fadeTrans.setDuration(Duration.millis(1000));
		fadeTrans.setFromValue(1.0);
		fadeTrans.setToValue(3.0);
		fadeTrans.setCycleCount(6);
		fadeTrans.setAutoReverse(true);
		fadeTrans.play();
		
		//create a sub menu inside the main menu
		MenuItem menu4Item4 = new MenuItem("Sequential Transition");
		polygonMenu.getItems().add(menu4Item4);
		menu4Item4.setOnAction(new EventHandler<ActionEvent>() {
			
			//allow user the play all the transition from the menu in order
			@Override
			public void handle(ActionEvent event) {
				SequentialTransition seqT =  new SequentialTransition(gp.getChildren().get(4), rotateTrans, scaleTrans, fadeTrans);
				seqT.play();
			}
		});
		
		//create colors for the shape
		PhongMaterial redMaterial = new PhongMaterial();
		redMaterial.setDiffuseColor(Color.ORANGERED);
		redMaterial.setSpecularColor(Color.GREY);
		
		PhongMaterial orangeMaterial = new PhongMaterial();
		orangeMaterial.setDiffuseColor(Color.ORANGE);
		orangeMaterial.setSpecularColor(Color.BLACK);
		
		PhongMaterial GreenMaterial = new PhongMaterial();
		GreenMaterial.setDiffuseColor(Color.GREENYELLOW);
		GreenMaterial.setSpecularColor(Color.BLACK);
		
		//creating shapes
		Sphere sphere = new Sphere();
		sphere.setRadius(100);
		sphere.setMaterial(orangeMaterial);
		
		Cylinder cylinder = new Cylinder();
		cylinder.setHeight(175);
		cylinder.setRadius(90);
		cylinder.setMaterial(GreenMaterial);
		
		Box box = new Box(220, 220, 220);
		box.setMaterial(redMaterial);
			
		Polygon polygon = new Polygon();
		polygon.getPoints().addAll(new Double[] { 100.0, 250.0, 200.0, 100.0, 300.0, 100.0, 200.0, 250.0});
		polygon.setFill(Color.BLUEVIOLET);
		
		//add the shape to a specific row and column
		gp.add(sphere, 0, 0);
		gp.add(cylinder, 1, 0);
		gp.add(box, 0, 1);
		gp.add(polygon, 1, 1);
		
		//set the grid pane to be the bottom in border pane
		root.setBottom(gp);
		
		stage.setScene(new Scene(root, 425, 460));
		stage.setTitle("Animation");	//title
		stage.show();
	}

}
