private <U> void mixinRecursivelyHelper(MyLinkedList<U> otherList,
										BiPredicate<? super T, ? super U> biPred,
										Function<? super U, ? extends T> fct,
										Predicate<? super U> predU,
										ListItem<U> pSrc,
										ListItem<T> pDest,
										int index) throws MyLinkedListException {
	if (pSrc == null) {
		return;
	}
    ...
}
