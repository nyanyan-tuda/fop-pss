public <U> void mixinRecursively(MyLinkedList<U> otherList,
 BiPredicate<? super T, ? super U> biPred, Function<? super U, ? extends T>
 fct, Predicate<? super U> predU) throws MyLinkedListException { ... }
