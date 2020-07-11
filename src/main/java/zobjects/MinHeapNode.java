package zobjects;

/**
 * Created by gadzik on 11.07.20.
 */
public class MinHeapNode
{
    public int element; // The element to be stored

    // index of the array from
    // which the element is taken
    public int i;

    // index of the next element
    // to be picked from array
    public int j;

    public MinHeapNode(int element, int i, int j)
    {
        this.element = element;
        this.i = i;
        this.j = j;
    }
};