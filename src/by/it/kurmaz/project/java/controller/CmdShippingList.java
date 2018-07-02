package by.it.kurmaz.project.java.controller;

import by.it.kurmaz.project.java.DAO.DAO;
import by.it.kurmaz.project.java.beans.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CmdShippingList extends Cmd {
    @Override
    ActionResult execute(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        HttpSession session = req.getSession();
        Object isUser = session.getAttribute("user");
        Object isAdmin = session.getAttribute("admin");
        if (isUser == null && isAdmin == null)
            return new ActionResult(Actions.INDEX);
        else if (isAdmin != null)
        {
            String where = "WHERE Completed = 0";
            List<ShippingList> list = DAO.getDao().shippingList.getAll(where);
            List<ShippingItem> itemList = new ArrayList<>();
            for (ShippingList ship: list) {
                int catalogID = ship.getCatalog_ID();
                where = String.format(Locale.US, "WHERE ID='%d'", catalogID);
                List<Catalog> catalogList = DAO.getDao().catalog.getAll(where);
                Catalog catalogItem = catalogList.get(0);
                ShippingItem item = new ShippingItem(catalogItem.getName(), Integer.parseInt(ship.getQuantity()), catalogItem.getPrice(), ship.getOrder_ID());
                itemList.add(item);
            }
            req.setAttribute("itemlist", itemList);
            return new ActionResult("getshippinglist");
        }
        else {
            User user = (User) isUser;
            int user_ID = (int) user.getId();
            String where = String.format(Locale.US, "WHERE Completed = 0 AND Users_ID='%d'", user_ID);
            List<Order> orderList = DAO.getDao().order.getAll(where);
            List<ShippingItem> itemList = new ArrayList<>();
            for (Order order: orderList) {
                int order_id = (int) order.getId();
                where = String.format(Locale.US, "WHERE Orders_ID='%d'", order_id);
                List<ShippingList> list = DAO.getDao().shippingList.getAll(where);
                for (ShippingList ship: list) {
                    int catalogID = ship.getCatalog_ID();
                    where = String.format(Locale.US, "WHERE ID='%d'", catalogID);
                    List<Catalog> catalogList = DAO.getDao().catalog.getAll(where);
                    Catalog catalogItem = catalogList.get(0);
                    ShippingItem item = new ShippingItem(catalogItem.getName(), Integer.parseInt(ship.getQuantity()), catalogItem.getPrice(), ship.getOrder_ID());
                    itemList.add(item);
                }
            }
            req.setAttribute("itemlist", itemList);
            return new ActionResult("getshippinglist");
        }
    }
}
