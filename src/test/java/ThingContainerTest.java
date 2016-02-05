import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Doc on 2/4/16.
 */
public class ThingContainerTest {

    @Test
    public void testAdd() throws Exception {
        ThingContainer container = new ThingContainer(4);
        ColorfulThing thing1 = new ColorfulThing(ColorfulThing.Color.BLACK);
        ColorfulThing thing2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing thing3 = new ColorfulThing(ColorfulThing.Color.PINK);
        ColorfulThing thing4 = new ColorfulThing(ColorfulThing.Color.GREEN);

        container.add(thing1);
        container.add(thing2);
        container.add(thing3);
        container.add(thing4);

        assertEquals("Not as expected ", "BLACK, BLUE, PINK, GREEN, ", container.printThings());
    }

    @Test
    public void testPop() throws Exception {
        ThingContainer container = new ThingContainer(4);
        ColorfulThing thing1 = new ColorfulThing(ColorfulThing.Color.BLACK);
        ColorfulThing thing2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing thing3 = new ColorfulThing(ColorfulThing.Color.PINK);
        ColorfulThing thing4 = new ColorfulThing(ColorfulThing.Color.GREEN);

        container.add(thing1);
        container.add(thing2);
        container.add(thing3);
        container.add(thing4);

        container.pop();

        assertEquals("Not as expected", "BLACK, BLUE, PINK, NULL, ", container.printThings());

    }

    @Test
    public void testRemove() throws Exception {
        ThingContainer container = new ThingContainer(4);
        ColorfulThing thing1 = new ColorfulThing(ColorfulThing.Color.BLACK);
        ColorfulThing thing2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing thing3 = new ColorfulThing(ColorfulThing.Color.PINK);
        ColorfulThing thing4 = new ColorfulThing(ColorfulThing.Color.GREEN);

        container.add(thing1);
        container.add(thing2);
        container.add(thing3);
        container.add(thing4);

        container.remove(ColorfulThing.Color.PINK);


        assertEquals("BLACK, BLUE, GREEN, NULL, ",  container.printThings());

    }

    @Test
    public void testRemove1() throws Exception {
        ThingContainer container = new ThingContainer(4);
        ColorfulThing thing1 = new ColorfulThing(ColorfulThing.Color.BLACK);
        ColorfulThing thing2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing thing3 = new ColorfulThing(ColorfulThing.Color.PINK);
        ColorfulThing thing4 = new ColorfulThing(ColorfulThing.Color.GREEN);

        container.add(thing1);
        container.add(thing2);
        container.add(thing3);
        container.add(thing4);

        container.remove(thing2);


        assertEquals("BLACK, PINK, GREEN, NULL, ",  container.printThings());

    }


    @Test
    public void testPrintThings() throws Exception {
        ThingContainer container = new ThingContainer(4);
        ColorfulThing thing1 = new ColorfulThing(ColorfulThing.Color.BLACK);
        ColorfulThing thing2 = new ColorfulThing(ColorfulThing.Color.BLUE);
        ColorfulThing thing3 = new ColorfulThing(ColorfulThing.Color.PINK);
        ColorfulThing thing4 = new ColorfulThing(ColorfulThing.Color.GREEN);

        container.add(thing1);
        container.add(thing2);
        container.add(thing3);
        container.add(thing4);

        assertEquals("BLACK, BLUE, PINK, GREEN, ",  container.printThings());
    }
}