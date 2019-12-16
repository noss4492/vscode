package __PlayGround__;

import java.util.LinkedList;

class HashTable{
    class Node{ // 자료를 노드에 담자(key-value)
        String key;
        String value;
    }
    public Node(String key, String value){
        this.key = key;
        this.value = value;
    }
    public String getValue(){
        return this.value();
    }
    public void setValue(String value){
        this.value = value;
    }

    LinkedList<Node>[] data;
    HashTable(int size){
        this.data = new Linkedlist[size];
    }
    
    int getHashCode(String key){
        int hashcode = 0;
        for(char c : key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }
    
    int convertToIndex(int hashcode){
        return hashcode % data.length;  // 배열의 크기로 나눠서 방의 인덱스로 삼음
    }

    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }
    void put(String key, String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        if(list == null){
            list = new LinkedList<>();
            data[index] = list;
        }
        Node Node = searchKey(list, key);
        if(Node == null){
            list.addLast(new Node(key, value));
        } else{
            Node.value(value);  // 그냥 덮어쓰기로 처리
        }
        String get(String key){
            int hashcode = getHashCode(key);
            int index = convertToIndex(hashcode);
            LinkedList<Node> list = data[index];
            Node node = searchKey(list, key);
            return node == null ? "not found" : node.value();
        }
    }
}

public class HashTable_SeparateChaining{
    public static void main(String[] args) {
        
    }
}