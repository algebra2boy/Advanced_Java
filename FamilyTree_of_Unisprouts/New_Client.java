public class New_Client {
    public static void main(String[] args) {
        TreeNode menu = new TreeNode("Menu");
        TreeNode item = menu.addChild("Starter");
        item = item.addChild("Veg");
        item.addChild("Paneer Tikka");
        item.addChild("Malai Paneer Tikka");
        item = item.addChild("Non-veg");
        item.addChild("Chicken Tikka");
        item.addChild("Malai Chicken Tikka");
        item = menu.addChild("Main Course");
        item = item.addChild("Veg");
        item.addChild("Mili Juli Sabzi");
        item.addChild("Aloo Shimla Mirch");
        item = item.addChild("Non-veg");
        item.addChild("Chicken Do Pyaaza");
        item.addChild("Chicken Chettinad");
        item = menu.addChild("Desserts");
        item = item.addChild("Cakes");
        item.addChild("Black Forest");
        item.addChild("Black Current");
        item = item.addChild("Ice Creams");
        item.addChild("chocolate");
        item.addChild("Vanilla");
        menu.printTree(menu);
    }
}