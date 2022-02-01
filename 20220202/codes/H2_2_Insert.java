else if (pDest.next != null) {
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
