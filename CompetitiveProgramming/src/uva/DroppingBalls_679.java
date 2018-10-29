package uva;

public class DroppingBalls_679 {

	static int[] heap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void add() {

		int i = 0;
		int parent = i / 2;
		int left = i * 2;
		int right = i * 2 + 1;

	}

	static int binarySearch(int arr[]) {

		int max = 12331;
		int min = 0;
		int act = 32;
		int mid = 0;
		while (min <= max) {
			mid = (max + min) / 2;

			if (act == arr[mid]) {

				break;
			}
			if (act < arr[mid]) {
				max = mid + 1;
			} else {
				min = mid + 1;
			}
		}
		return mid;
	}

	static class BinaryTree {

		static Node root;

		static void add(int act) {

			if (root == null) {

				root = new Node(act);
			} else {

				Node nAct = new Node(act);
				add(root, nAct);

			}

		}

		static void add(Node p, Node act) {

			if (act.val > p.val) {
				if (p.right == null) {
					p.right = act;
				} else {
					add(p.right, act);
				}
			} else {
				if (p.left == null) {
					p.left = act;
				} else {
					add(p.left, act);
				}
			}
		}

		static class Node {

			Node left;
			Node right;
			int val;

			Node(int val) {
				this.val = val;
			}
		}

	}

}
