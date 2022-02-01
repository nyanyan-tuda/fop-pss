private <U> void mixinRecursivelyHelper(MyLinkedList<U> otherList,
										BiPredicate<? super T, ? super U> biPred,
										Function<? super U, ? extends T> fct,
										Predicate<? super U> predU,
										ListItem<U> pSrc,
										ListItem<T> pDest,
										int index) throws MyLinkedListException {
	// We have to insert all elements from the other list until there are no elements left
	if (pSrc == null) {
		return;
	}
	U key = pSrc.key;
	// Check if source element should be inserted
	if (!predU.test(key)) {
		throw new MyLinkedListException(index, key);
	} else if (pDest.next != null) {
		T element = pDest.next.key;
		if (biPred.test(element, key)) {
			T mapped = fct.apply(key); ListItem<T> item = new ListItem<>(mapped);
			// Element will be inserted before the element that fulfills the
			// predicate
			// Before -> New Element -> Predicate true element
			item.next = pDest.next;
			pDest.next = item;

			// Update pointer since we added an element from the other list to this
			// list
			pSrc = pSrc.next; pDest = pDest.next;
		}
	} else {
		// Case current == null only occurs if we reached the tail of the list
		T mapped = fct.apply(key);
		pDest.next = new ListItem<>(mapped);
		pSrc = pSrc.next;
	}
	// Iterate over the next elements
	mixinRecursivelyHelper(otherList, biPred, fct, predU,
		pSrc, pDest.next,
		index + 1);
}