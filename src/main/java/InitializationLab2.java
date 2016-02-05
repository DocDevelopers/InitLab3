public class InitializationLab2{
    public InitializationLab2(){

    }
}

class ThingContainer{
    ColorfulThing[] colorfulThings;
    private int arrayIndex = 0;

    public ThingContainer(int amountOfThings){
        this.colorfulThings = new ColorfulThing[amountOfThings];

    }

    public void add(ColorfulThing thing) throws IndexOutOfBoundsException{
        //If space is available, add the Thing.
        if(arrayIndex < colorfulThings.length){
            colorfulThings[arrayIndex] = thing;
            arrayIndex++;
        }
        else
            System.err.print("ThingContainer is Full");
    }

    public ColorfulThing pop(){
        ColorfulThing result = null;

        //Start searching from the end of the array.
        for(int i = colorfulThings.length-1 ; i>=0; i--){
            ColorfulThing last = colorfulThings[i];
            if(last != null){
                result = colorfulThings[i];
                colorfulThings[i] = null;
                arrayIndex = i;
                return result;
            }

        }

        return result;
    }

    public ColorfulThing remove(ColorfulThing.Color color){
        ColorfulThing thing = null;
        for(int i = 0; i<colorfulThings.length; i++){
            thing = colorfulThings[i];

            if(thing != null) {
                if (thing.getColor() != null && thing.getColor() == color) {
                    colorfulThings[i] = null;
                    break;
                }
            }
        }

        adjustArray();
        return thing;
    }

    public ColorfulThing remove(ColorfulThing thing){
        ColorfulThing result = null;
        for(int i = 0; i<colorfulThings.length; i++){
            ColorfulThing arrayThing = colorfulThings[i];

            if(arrayThing != null)
                if(arrayThing == thing) {
                    result = colorfulThings[i];
                    colorfulThings[i] = null;
                    break;
                }
        }

        adjustArray();

        return result;
    }

    //Compress all objects so that all empty spaces are at the end of the array.
    private void adjustArray(){
        for(int i = 0; i<colorfulThings.length; i++){
            ColorfulThing arrayThing = colorfulThings[i];
            //If an empty space... Do stuff.
            if(arrayThing == null){
                //If not the last one, check to the right to see if there are any objs.
                for(int j = i; j< colorfulThings.length; j++){
                    ColorfulThing fragmentThing = colorfulThings[j];
                    //If found a fragmented obj bring it back to the last empty space.
                    if(fragmentThing != null){
                        colorfulThings[j] = null;
                        colorfulThings[i] = fragmentThing;
                        break;
                    }
                }
            }
        }

        //Reset index to the first empty spot.

        for(int i = 0; i<colorfulThings.length; i++){
            ColorfulThing thing = colorfulThings[i];

            if(thing == null)
                arrayIndex = i;
        }
    }

    public String printThings(){
        String result = "";
        for(ColorfulThing color : colorfulThings){
            if(color != null) {
                if (color.getColor() != null)
                    result += color.getColor() + ", ";
            }
            else if(color == null)
                    result += "NULL, ";
        }

        return result;
    }
}

class ColorfulThing{
    private Color color;

    public ColorfulThing(Color mColor){
        this.color = mColor;
    }
    Color getColor(){
        return this.color;
    }

    enum Color{
        RED,
        BLUE,
        GREEN,
        PINK,
        BLACK
    }

}


