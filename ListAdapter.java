package myAdapter;

import java.util.Vector;

//There arent any ClassCastExcpetion (and similar exception) cuz we r supposing everything is Object

public class ListAdapter implements HList{

    private Vector<Object> myVec;

    public ListAdapter(){}

    public ListAdapter(Vector<Object> a){
        for (int i = 0; i < a.size(); i ++)
            myVec.add(a.elementAt(i));
    }

    @Override
    public int size() {
        return myVec.size();
    }

    @Override
    public boolean isEmpty() {
        return myVec.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new NullPointerException();
        
        return myVec.contains(o);
    }

    @Override
    public HIterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] myArray = new Object[myVec.size()];
        myVec.copyInto(myArray);
        return myArray;
    }

    @Override
    public Object[] toArray(Object[] a) {
        if (a==null)
            throw new NullPointerException();
        
        if (a.length < myVec.size())
            a = new Object[myVec.size()];
        
        myVec.copyInto(a);
        
        return a;
    }

    @Override
    public boolean add(Object o) {
        if (o == null)
            throw new NullPointerException();
               
        myVec.addElement(o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();

        return myVec.removeElement(o);
    }

    @Override
    public boolean containsAll(HCollection c) {
        if (c.contains(null) || c == null) //here and in similar piece of code the check "c.contains(null)" isnt really usefull: add doesnt accept "null" as argoument                                            
            throw new NullPointerException(); //but myVec way prevent myVec integrity
        
        HIterator tmp = c.iterator();

        while(tmp.hasNext())
            if (!(myVec.contains(tmp.next())))
                return false;

        return true;
    }

    @Override
    public boolean addAll(HCollection c) {
        if (c.contains(null))
            throw new NullPointerException();
        else if (c == null)
            return false;
        
        HIterator tmp = c.iterator();

        while(tmp.hasNext())
            c.add(tmp.next());
        
        return true;
    }

    @Override
    public boolean addAll(int index, HCollection c) {
        if (c.contains(null))
            throw new NullPointerException();
        else if (index < 0 || index > myVec.size())
            throw new IndexOutOfBoundsException();
        else if (c == null)
            return false;

        HIterator tmp = c.iterator();
        while (tmp.hasNext()){
            myVec.insertElementAt(tmp.next(), index);
            index++;
        }

        return true;
    }

    @Override
    public boolean removeAll(HCollection c) {
        if (c.contains(null) || c == null)
            throw new NullPointerException();
        
        int oldSize = myVec.size(); //save old size
        HIterator tmp = c.iterator();
        while (tmp.hasNext())       //...removing...
            myVec.remove(tmp.next());
        
        if (myVec.size() == oldSize)    //if it has still the same size, nothing has been deleted
            return false;
        
        return true;
    }

    @Override
    public boolean retainAll(HCollection c) {
        if (c.contains(null) || c == null)
            throw new NullPointerException();
        
        int oldSize = myVec.size(); //save old size

        Vector<Object> tmpVec = new Vector<Object>();

        HIterator tmp = c.iterator();
        while (tmp.hasNext()){
            Object elem = tmp.next();
            if (myVec.contains(elem)){
                tmpVec.add(elem);
            }
        }

        if (myVec.size() == oldSize)    //if it has still the same size, nothing has been deleted
            return false;
        
        return true;
    }

    @Override
    public void clear() {
        myVec.removeAllElements();
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index > myVec.size())
            throw new IndexOutOfBoundsException();
        
        return myVec.elementAt(index);
    }

    @Override
    public Object set(int index, Object element) {
        if (element == null)
            throw new NullPointerException();
        else if (index < 0 || index > myVec.size())
            throw new IndexOutOfBoundsException();
        
        Object old = myVec.elementAt(index);
        myVec.setElementAt(element, index);

        return old;
    }

    @Override
    public void add(int index, Object element) {
        if (element == null)
            throw new NullPointerException();
        else if (index < 0 || index > myVec.size())
            throw new IndexOutOfBoundsException();

        myVec.insertElementAt(element, index);
    }

    @Override
    public Object remove(int index) {
        if (index < 0 || index > myVec.size())
            throw new IndexOutOfBoundsException();
        
        Object old = myVec.elementAt(index);
        myVec.removeElementAt(index);
        
        return old;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null)
            throw new NullPointerException();
    
        return myVec.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null)
            throw new NullPointerException();
        
        int in = -1;
        for (int i = 0; i < myVec.size(); i++)
            if (o == myVec.elementAt(i))
                in = i;
        
        return in;
    }

    @Override
    public HListIterator listIterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HList subList(int fromIndex, int toIndex) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int hashCode(){
        // TODO Auto-generated method stub
        return -1;
    }
    
    @Override
    public boolean equals(Object o){
        // TODO Auto-generated method stub

        /*int hashCode = 1;
        Iterator i = list.iterator();
        while (i.hasNext()) {
            Object obj = i.next();
            hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
        }
        return hashCode;*/
        return true;
    }

}