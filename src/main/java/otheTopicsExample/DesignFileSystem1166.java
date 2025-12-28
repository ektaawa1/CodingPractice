package otheTopicsExample;

import java.util.HashMap;

/**
 * Example:
 * ["FileSystem","createPath","createPath","get","createPath","get"]
 * [[],["/leet",1],["/leet/code",2],["/leet/code"],["/c/d",1],["/c"]]
 * Output:
 * [null,true,true,2,false,-1]
 * Explanation:
 * FileSystem fileSystem = new FileSystem();
 *
 * fileSystem.createPath("/leet", 1); // return true
 * fileSystem.createPath("/leet/code", 2); // return true
 * fileSystem.get("/leet/code"); // return 2
 * fileSystem.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
 * fileSystem.get("/c"); // return -1 because this path doesn't exist.
 */
class FileNode{
    HashMap<String, FileNode> children = new HashMap<>();
    Integer value = null; // means "no value assigned"
    //A path (directory or file) may have a value
    //Or it may not have any value yet
    // int always has a value (default = 0)
    //So even if the path was never created, the value inside the node would be 0.
    //get("/abc") but the path doesn't exist however the output will be 0 which is wrong.
}
public class DesignFileSystem1166 {
    FileNode root;

    public DesignFileSystem1166(){
        root = new FileNode();
    }

    public boolean createPath(String path, int val){
        if(path.isEmpty() || path.equals("/")){
            return false;
        }
        String[] parts = path.split("/"); //"/leet/code".split("/") gives ["", "leet", "code"]
        FileNode curr = root;
        for (int i = 1; i < parts.length - 1; i++) { //starting from index 1 to avoid ""
            String dir = parts[i];

            // Parent must exist
            if (!curr.children.containsKey(dir))
                return false;

            curr = curr.children.get(dir);
        }

        String last = parts[parts.length - 1];

        // Path must not already exist
        if (curr.children.containsKey(last))
            return false;

        // Create new node
        FileNode newNode = new FileNode();
        newNode.value = val;
        curr.children.put(last, newNode);
        return true;
    }

    public int get(String path){
        if (path.equals("/") || path.isEmpty())
            return -1;

        String[] parts = path.split("/");

        FileNode curr = root;

        for (int i = 1; i < parts.length; i++) {
            String dir = parts[i];

            if (!curr.children.containsKey(dir))
                return -1;

            curr = curr.children.get(dir);
        }

        return curr.value == null ? -1 : curr.value;
    }
}
