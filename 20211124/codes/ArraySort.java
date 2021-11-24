public abstract class ArraySort implements Sortable {

  protected final int[] array;

  public ArraySort(int[] array) {
    this.array = array;
  }

  @Override
  public void sort() {
    sort(0, array.length - 1);
  }

}
