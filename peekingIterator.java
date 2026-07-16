p// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.Iterator;
import java.util.NoSuchElementException;

class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer nextCache;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        advanceCache();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (nextCache == null) {
            throw new NoSuchElementException();
        }
        return nextCache;
    }

    @Override
    public Integer next() {
        if (nextCache == null) {
            throw new NoSuchElementException();
        }
        Integer currentElement = nextCache;
        advanceCache();
        return currentElement;
    }

    @Override
    public boolean hasNext() {
        return nextCache != null;
    }

    // Helper method to move the internal pointer forward
    private void advanceCache() {
        if (iterator.hasNext()) {
            nextCache = iterator.next();
        } else {
            nextCache = null;
        }
    }
}
