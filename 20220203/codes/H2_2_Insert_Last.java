else {
	// Case current == null only occurs if we reached the tail of the list
	T mapped = fct.apply(key);
	pDest.next = new ListItem<>(mapped);
	pSrc = pSrc.next;
}