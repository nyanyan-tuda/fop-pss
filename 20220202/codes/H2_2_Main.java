public <U> void mixinRecursively(MyLinkedList<U> otherList,
								 BiPredicate<? super T, ? super U> biPred,
								 Function<? super U, ? extends T> fct,
								 Predicate<? super U> predU) throws MyLinkedListException {
	// Cannot merge other list if its empty
	if (otherList.head == null) return;
	// Extend the list item by one dummy node to simplify the check with the
	// successor node
	ListItem<T> dummy = new ListItem<>(); dummy.next = head;
	mixinRecursivelyHelper(otherList, biPred, fct, predU, otherList.head, dummy, 0);
	head = dummy.next; // Restore head
}