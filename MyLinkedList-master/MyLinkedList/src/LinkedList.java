/**
 * 
 * @author Taha Amir
 * @version 1.0
 * @param <E> type
 */
public class LinkedList<E>
{
    ////////////////////////////////
    // private Boolean add( Object o  ); 
    // private void add( int loc, Object o  ); 
    // private Object remove( int loc  ); 
    // private boolean remove( Object o  ); 
    // private Object set( int loc, Object o  ); 
    // private Object get( int loc  ); 
    // private int size; 
    // private int indexOf( Object o  ); 
    // private void clear(   );
    // private boolean contains( Object o  );
    // private int lastIndexOf( Object o  );
    // private Object[] toArray(   );
    // private String toString(   ); 
    // private boolean equals( Object o  );
    // boolean isObjectmpty(   ) 


    private Node<E> head;
    private int size;

    /**
     * linkedlist with head = null
     */
    public LinkedList( )
    {
        head = null;
        size = 0;
    }
    
    /**
     * 
     * @param loc location to check
     */
    private void locationCheck( int loc )
    {
        if ( loc < 0 || loc >= size )
        {
            throw new IndexOutOfBoundsException( );
        }
    }

    /**
     * 
     * @param data data adding
     * @return true if added
     */
    public boolean add( E data )
    {
        if ( head != null )
        {
            Node<E> c;
            for ( c = head; c.next != null; c = c.next ) { }
            c.next = new Node<E>( null, data ) ;
        }
        else
        {
            head = new Node<E>( null, data );
        }
        
        size++;
        return true;
    }

    /**
     * 
     * @param loc location
     * @param o object to add
     */
    public void add( int loc, E o )
    {
        
        if (  loc ==  0   )
        {
            if ( head == null )
            {
                add( o );
                return;
            }
            else
            {
                head = new Node<E>( head, o );
                size++;
                return;
            }
        }
        if ( loc == size )
        {
            add(  o   );
            return;
        }
        locationCheck( loc );
        int location = 0;
        
        Node<E> current = head;        
        for ( location = 0; location  <= loc - 2; location++ )
        {
            current = current.next;
        }
        Node<E> newN = new Node<E>( current.next, o ) ;
        current.next = newN;
        
        size++;
        
    }
    

    
    /**
     * 
     * @param loc the location of element
     * @return returns the removed element
     */
    public E remove( int loc )
    {
        locationCheck( loc );
        
        E temp = null;
        
        if ( loc == 0 )
        {
            temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
        Node<E> current = head;
        for ( int i = 0; i != loc - 1; i++ )
        {
            current = current.next;
        }
        temp = ( E ) current.next.data;
        current.next = current.next.next;
        size--;
        return temp;
    }

    /**
     * 
     * @param o the object to remove
     * @return true if removed
     */
    public boolean remove( E o )
    {
        Node<E> current = head;
        Node<E> previous = new Node<E>( head, null );
        
        if ( this.contains( o ) )
        {
            while ( current.next != null  )
            {
                if ( current.data == o  )
                {
                    previous.next = current.next;
                    size--;
                    return true;
                }
                else
                {
                    previous = current;
                    current = current.next;
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @param loc location to be changed
     * @param o the object that is intended
     * @return the old object
     */
    public E set( int loc, E o )
    {
        locationCheck( loc );
        Node<E> current = head;
        E temp = null;
        int location = 0;
        while ( location != loc )
        {
            location++;
            current = current.next;
        }
        temp = current.data;
        current.data = o;
        return temp;
    }
    
    /**
     * 
     * @param loc the location that shall be grabbed
     * @return the object at loc
     */
    public E get( int loc )
    {
        locationCheck( loc  );
        Node<E> current = head;
        int location = 0;
        while ( current.next != null )
        {
            if ( location == loc )
            {
                break;
            }
            else
            {
                current = current.next;
                location++;
            }
        
            
        }
        return current.data;
        
    }
    
    /**
     * 
     * @return size of linkedlist
     */
    public int size( )
    {
        return size;
    }
    
    /**
     * 
     * @param o object
     * @return int location
     */
    public int indexOf( Object o )
    {
        Node<E> current = head;
        int location = 0;
        
        while ( current != null )
        {
            if ( current.data.equals( o ) )
            {
                return location;
            }
            location++;
            current = current.next;
        }
        return -1;
    }

    /**
     * clears list
     */
    public void clear( )
    {
        head = null;
        size = 0;
    }
    
    /**
     * 
     * @param o object to check
     * @return true if contains
     */
    public boolean contains( E o )
    {
        return indexOf( o ) > -1;
    }
    
    /**
     * 
     * @param o o to check
     * @return last index
     */
    public int lastIndexOf( E o )
    {
        Node<E> current = head;
        int last = -1;
        int i = 0;
        if ( this.contains( o ) )
        {
            while ( current != null )
            {
                if ( current.data == o )
                {
                    last = i;
                }
                i++;
                current = current.next;
                
            }
        }
        return last;
    }
    
    /**
     * 
     * @return array
     */
    public Object[] toArray( )
    {
        int location = 0;
        if ( head == null )
        {
            return new Object[0];
        }
        Object[] temp = new Object[size];
        Node<E> current;
        for ( current = head; location < size; current = current.next )
        {
            temp[location] = current.data;
            location++;  //[5 6 7]
        }
        return temp;
    }
    
    /**
     * @return string to return
     */
    public String toString( )
    {
        if ( size == 0 )
        {
            return "[]";
        }
        
        Node<E> current = head.next;
        String s = "[" + head.data;
        while ( current != null )
        {
            s += ", " + current.data;
            current = current.next;
        }
        return s + "]";
    }
    
    /**
     * @return true if equals
     * @param o object to check
     */
    public boolean equals( Object o )
    {
        return true;
    }
    
    /**
     * 
     * @return true if empty
     */
    public boolean isEmpty( ) 
    {
        return size == 0;
    }
    
    /**
     * 
     * @author amirta18
     * @version 1.0
     * @param <E> type
     */
    @SuppressWarnings("hiding")
    private class Node<E>
    {
        private Node<E> next;
        private E data;


        /**
         * 
         * @param n next node
         * @param d data of type e
         */
        public Node( Node<E> n, E d )
        {
            super( );
            next = n;
            data = d;
        }
        
    }
}