package hashTableTree;

public class Tree {

	private Node root;

	public void insert(int key, Object value) {
		this.root = this.insert(this.root, key, value);
	}

	private Node insert(Node root, int key, Object value) {
		if (root == null) {
			Node node = new Node();
			node.setKey(key);
			node.setValue(value);
			return node;
		} else {
			if (key < root.getKey()) {
				root.setLeft(this.insert(root.getLeft(), key, value));
			} else if (key > root.getKey()) {
				root.setRight(this.insert(root.getRight(), key, value));
			}
		}
		return root;
	}

	public void remove(int key) {
		this.root = this.remove(this.root, key);
	}

	/* Função recursiva para remover um nó */
	private Node remove(Node root, int key) {
		/* Se a raiz for null, retorna null */
		if (root == null) {
			return null;
		}

		/* Se a chave for menor que a raiz, vai para a esquerda
		*  Senão se a chave for maior que a raiz vai para a direita
		* Ambos recursivamente até achar a key certa, a partir daí cai no else para remoção*/
		if (key < root.getKey()) {
			root.setLeft(this.remove(root.getLeft(), key));
		} else if (key > root.getKey()) {
			root.setRight(this.remove(root.getRight(), key));
		} else {
			/* Nó folha */
			if (root.getLeft() == null && root.getRight() == null) {
				return null;
			}

			/* Nó com um filho */
			else if (root.getLeft() == null) {
				return root.getRight();
			} else if (root.getRight() == null) {
				return root.getLeft();
			}

			/* Nó com dois filhos */
			else {
				Node minNodeForRight = minimumElement(root.getRight());
				root.setKey(minNodeForRight.getKey());
				root.setValue(minNodeForRight.getValue());
				root.setRight(this.remove(root.getRight(), minNodeForRight.getKey()));
			}
		}

		return root;
	}

	/* Função para achar o menor elemento de uma determinada árvore */
	private Node minimumElement(Node root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}

	private String printPreOrder(Node root, int lvl) {
		String out = "";
		for (int i = 0; i < lvl; i++) {
			out += "\t";
		}
		out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
		out += "\n";
		out += (root.getLeft() != null ? printPreOrder(root.getLeft(), lvl + 1) : "");
		out += (root.getRight() != null ? printPreOrder(root.getRight(), lvl + 1) : "");
		return out;
	}
	
	private String printInOrder(Node root, int lvl) {
	    String out = "";
	    if(root != null) {
	        out += (root.getLeft() != null ? printInOrder(root.getLeft(), lvl + 1) : "");
	        for (int i = 0; i < lvl; i++) {
	            out += "\t";
	        }
	        out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
	        out += "\n";
	        out += (root.getRight() != null ? printInOrder(root.getRight(), lvl + 1) : "");
	    }
	    return out;
	}
	
	private String printPostOrder(Node root, int lvl) {
	    String out = "";
	    if(root != null) {
	        out += (root.getLeft() != null ? printPostOrder(root.getLeft(), lvl + 1) : "");
	        out += (root.getRight() != null ? printPostOrder(root.getRight(), lvl + 1) : "");
	        for (int i = 0; i < lvl; i++) {
	            out += "\t";
	        }
	        out += root.getKey() + ": " + (root.getValue() != null ? root.getValue() : "null");
	        out += "\n";
	    }
	    return out;
	}

	

	@Override
	public String toString() {
		if(root != null) {
		return "Pré-ordem: \n" + this.printPreOrder(this.root, 0) + "Em ordem: \n" + this.printInOrder(root, 0)
		+ "Pós-ordem: \n" + this.printPostOrder(root, 0);
		}
		return "Empty tree";
	}

	public Object get(int key) {
		return this.get(this.root, key);
	}

	private Object get(Node root, int key) {
		if (root != null) {
			if (key < root.getKey()) {
				return this.get(root.getLeft(), key);
			} else if (key > root.getKey()) {
				return this.get(root.getRight(), key);
			} else {
				return root.getValue();
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Tree t = new Tree();

		t.insert(20, "20");
		t.insert(5, "5");
		t.insert(40, "40");
		t.insert(0, "0");
		t.insert(10, "10");
		t.insert(30, "30");
		t.insert(50, "50");
		System.out.println(t.toString());
		
		t.remove(40);
		
		System.out.println(t.toString());
	}
}
