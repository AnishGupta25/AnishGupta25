public static void main(String[] args) {
    
    
}

static Node leftp;
public void fold() {
    leftp = head;
    foldhelper(head, 0);
}

public void foldhelper(Node node, int idx) {
    if (node == null) {
    return;
    }
    foldhelper(node.next, idx + 1);
    Node right = node;

    if (idx > size / 2) {
    Node temp = leftp.next;
    leftp.next = right;
    right.next = temp;
    leftp = temp;
    }
    else if (idx == size / 2) {
    tail = right;
    tail.next = null;
    return;
    }
}