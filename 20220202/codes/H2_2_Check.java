// Check if source element should be inserted
if (!predU.test(key)) {
	throw new MyLinkedListException(index, key);
}