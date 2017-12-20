package characters;

import game.GameEngine;
import javafx.application.Platform;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import objects.GameObject;
import wall.Wall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 12/19/17.
 */
public class Shadow extends GameObject {

    private int rays;
    private int rayLength;
    private int clearance;
    private Pane pane;
    private Shape overlay;
    private Player player;


    public Shadow(GameEngine gameEngine, Player player) {
        super(gameEngine);
        rays = 40;
        rayLength = 300;
        clearance = 70;

        pane = gameEngine.getPane();
        overlay = new Rectangle(0, 0, pane.getWidth(), pane.getHeight());
        overlay.setFill(Color.BLACK);
        pane.getChildren().add(overlay);

        this.player = player;


    }

    @Override
    public void update() {
        List<Line> sightLines = new ArrayList<>();

        for (int i = 0; i < rays; i++) {
            double angle = (2*Math.PI / rays) * i;
            double minLength = rayLength;

            double x1 = player.getX() + player.getImageView().getFitWidth() / 2;
            double y1 = player.getY() + player.getImageView().getFitHeight() / 2;
            double x2 = x1 + Math.cos(angle) * rayLength;
            double y2 = y1 + Math.sin(angle) * rayLength;

            pane.getChildren().remove(overlay);
            overlay = new Rectangle(0, 0, pane.getWidth(), pane.getHeight());
            pane.getChildren().add(overlay);

            Line ray = new Line(x1, y1, x2, y2);

            List<Point2D> endPoints = new ArrayList<>();
            for (GameObject gameObject : gameEngine.getGameObjects()) {
                if (!(gameObject instanceof Wall)) continue;
//                if (gameObject == player) continue;
                Wall gameObjectWall = (Wall) gameObject;
                double minX = gameObjectWall.getImageView().getBoundsInLocal().getMinX();
                double minY = gameObjectWall.getImageView().getBoundsInLocal().getMinY();
                double maxX = gameObjectWall.getImageView().getBoundsInLocal().getMaxX();
                double maxY = gameObjectWall.getImageView().getBoundsInLocal().getMaxY();

                List<Line> segments = new ArrayList<>();
                segments.add(new Line(minX, minY, maxX, minY));
                segments.add(new Line(maxX, minY, maxX, maxY));
                segments.add(new Line(maxX, maxY, minX, maxY));
                segments.add(new Line(minX, maxY, minX, minY));


                for (Line segment : segments) {
                    double x3 = segment.getStartX();
                    double x4 = segment.getEndX();
                    double y3 = segment.getStartY();
                    double y4 = segment.getEndY();

                    double d = (x1-x2)*(y3-y4) - (y1-y2)*(x3-x4);
                    if (d == 0) continue;

                    double xi = ((x3-x4)*(x1*y2-y1*x2)-(x1-x2)*(x3*y4-y3*x4))/d;
                    double yi = ((y3-y4)*(x1*y2-y1*x2)-(y1-y2)*(x3*y4-y3*x4))/d;

                    if (segment.contains(new Point2D(xi, yi)) && ray.contains(new Point2D(xi, yi))) {
                        endPoints.add(new Point2D(xi, yi));
                    }
                }
            }
            double sightDistance = rayLength;
            for (Point2D point : endPoints) {
                double length = Math.sqrt(Math.pow((x1-point.getX()), 2) + Math.pow((y1-point.getY()), 2));
                if (length < sightDistance) {
                    sightDistance = length;
                    x2 = point.getX();
                    y2 = point.getY();
                }
            }

            x2 = x2 + clearance * Math.cos(angle);
            y2 = y2 + clearance * Math.sin(angle);

            sightLines.add(new Line(x1, y1, x2, y2));

            pane.getChildren().remove(overlay);
            Polygon sightPolygon = new Polygon();
            for (Line sightLine : sightLines) {
                sightPolygon.getPoints().addAll(sightLine.getEndX(), sightLine.getEndY());
            }
            overlay = Shape.subtract(overlay, sightPolygon);

            overlay.setFill(Color.BLACK);
            pane.getChildren().add(overlay);
        }

    }
}
