/**
 * 
 * @author Taha Amir, Anton Xereas
 * @version 1.0
 * @param <E>
 *            E is the type that the arraylist shall contain.
 */
public class ArrayList<E> {

    private int size;
    private Object[] objs;

    /**
     * creates an arraylist with size 0, it's empty
     */
    public ArrayList() {
        this.size = 0;
        objs = new Object[10];

    }

    ////////////////////////////////
    /**
     * doubles the size of the array
     */
    private void doubleIt() {

        Object[] temp = new Object[(objs.length) * 2];
        for (int i = 0; i < objs.length; i++) {
            temp[i] = objs[i];
        }
        this.objs = temp;
    }

    ////////////////////////////////
    // private Boolean add(Object o); **
    // private void add(int loc, Object o); **
    // private Object remove(int loc); **
    // private boolean remove(Object o); **
    // private Object set(int loc, Object o); **
    // private Object get(int loc); **
    // private int size; **
    // private int indexOf(Object o); **
    // private void clear();
    // private boolean contains(Object o);
    // private int lastIndexOf(Object o);
    // private Object[] toArray();
    // private String toString(); **
    // private boolean equals(Object o);
    // boolean isObjectmpty() *

    /**
     * 
     * @param o
     *            the object that shall be added
     * @return returns true if it has been added, false if otherwise
     */
    public boolean add(E o) {
        // if ( objs.length == 0 ) {
        // System.out.println( objs.length );
        // this.doubleIt();
        // objs[ 0 ] = o;
        // size++;
        // return true;
        // }
        if (size + 1 >= objs.length) {
            this.doubleIt();
            objs[size] = o;
            size++;
            return true;
        } 
        else if (size == 0) {
            objs[0] = o;
            size++;
            return true;
        } 
        else {
            objs[size] = o;
            size++;
            return true;
        }
    }

    /**
     * 
     * @param loc
     *            the location that 'o' shall be added
     * @param o
     *            the object that shall be added
     */
    public void add(int loc, E o) {
        
        if (objs.length == size) {
            doubleIt();
        }
        for (int i = size; i >= loc; i--) {
            if (i == loc) {
                objs[loc] = o;
            } 
            else {
                objs[i] = objs[i - 1];
            }
        }
        size++;

    }

    /**
     * 
     * @param x
     *            place where the object that shall be removed is
     * @return returns the object that was removed
     */
    @SuppressWarnings("unchecked")
    public E remove(int x) {
        if (x >= size || x < 0) {
            throw new IndexOutOfBoundsException("Out of bounds: " + x);
        }
        E o = (E) objs[x];
        for (int i = 0; i < objs.length - 1; i++) {
            if (i + 1 > x) {
                objs[i] = objs[i + 1];
            }
        }
        size--;
        return o;
    }

    /**
     * 
     * @param o
     *            the object that shall be removed
     * @return returns true if the object is removed
     */
    public boolean remove(E o) {
        if (this.contains(o)) {
            remove(this.indexOf(o));
            return true;
        }
        return false;

    }

    /**
     * 
     * @param x
     *            the location at which the object that shall be changed resides
     * @param o
     *            the object that is desired in place of the previous one
     * @return returns the object that used to be there
     */
    @SuppressWarnings("unchecked")
    public E set(int x, E o) {
        if (x < 0 || size == 0 || x >= size) {
            throw new IndexOutOfBoundsException(x + "");
        }

        else {
            E temp = (E) objs[x];
            objs[x] = o;
            return temp;
        }
    }

    /**
     * 
     * @param loc
     *            the location of the object that shall be returned
     * @return the object that was at the location
     */
    @SuppressWarnings("unchecked")
    public E get(int loc) {
        if (size == 0 || loc < 0 || loc >= size) {
            throw new IndexOutOfBoundsException(loc + "");
        }

        else {
            return (E) objs[loc];
        }

    }

    /**
     * 
     * @return true if empty, false if not empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 
     * @return the size of the arraylist
     */
    public int size() {
        return this.size;
    }

    /**
     * clears the array
     */
    public void clear() {
        objs = new Object[objs.length];
        size = 0;
    }

    /**
     * @return returns the arraylist in string format
     */
    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        }
        String s = "[" + objs[0];
        for (int i = 1; i < size; i++) {
            s += ", " + objs[i];
        }
        return s + "]";

    }

    /**
     * @param o
     *            the object to check
     * @return returns true if the two are equal
     */

    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    /**
     * 
     * @return returns the arraylist in array form
     */
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = objs[i];
        }
        return (E[]) temp;
    }

    /**
     * 
     * @param o
     *            the object to check if it exists in the arraylist
     * @return true if it in the arraylist, false if not
     */
    public boolean contains(E o) {
        if (size == 0) {
            return false;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (objs[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param o
     *            the object to check the last occurrence of
     * @return the last location of the object, -1 if non-existent
     */
    public int lastIndexOf(E o) {
        for (int i = size - 1; i >= 0; i--) {
            if (objs[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 
     * @param o
     *            object to check the first occurrence of
     * @return returns the first location of object o
     */
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (objs[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

}
