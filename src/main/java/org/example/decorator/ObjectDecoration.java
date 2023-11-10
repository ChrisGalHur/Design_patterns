package org.example.decorator;

public class ObjectDecoration implements IObject{
    //VARIABLES
    private final IObject object;

    public ObjectDecoration(IObject object) {
        this.object = object;
    }

    @Override
    public String getDecoration1() {
        return object.getDecoration1() + ", Decoration1 plus";
    }

    @Override
    public String getDecoration2() {
        return object.getDecoration2() + ", Decoration2 plus";
    }
}
