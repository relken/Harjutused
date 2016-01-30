package com.zetcode;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Shape;

public interface Collidable{
    public enum CollisionState{
        WAITING,
        TOUCHING;
    }

    ObjectProperty<CollisionState> state = new SimpleObjectProperty<>(CollisionState.WAITING);
    public default ReadOnlyObjectProperty<CollisionState> collisionStateProperty(){return state;}
    public default CollisionState getCollisionState(){return state.get();}

    BooleanProperty collided = new SimpleBooleanProperty(false){{
        addListener((ObservableValue<? extends Boolean> observable1, Boolean oldValue, Boolean touching) -> {
            if(touching){
                state.set(CollisionState.TOUCHING);
            }else{
                state.set(CollisionState.WAITING);
            }
        });
    }};
    public default boolean hasCollided(){return collided.get();}
    public default BooleanProperty collidedProperty(){return collided;}

    public default void checkCollision(Shape src, Shape other){
        if(Shape.intersect(src, other).getBoundsInLocal().getWidth() > -1 && !getCollisionState().equals(CollisionState.TOUCHING)){
            collided.set(true);
            handleCollision(other);
        }else if(Shape.intersect(src, other).getBoundsInLocal().getWidth() <= 0){
            collided.set(false);
        }
    }

    public void handleCollision(Shape other);

}
