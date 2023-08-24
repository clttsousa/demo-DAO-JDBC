package application;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SellerDAO sellerDao = DaoFactory.createSellerDao();

        System.out.println(" =========================================================");
        System.out.println("| ---- TESTE 1: PESQUISAR VENDEDOR POR ID (findById) ---- |");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println(" ===========================================================================");
        System.out.println("| ---- TESTE 2: PESQUISAR VENDEDOR POR DEPARTAMENTO (findByDepartment) ---- |");

        Department department = new Department(2, null);
        List <Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list){
            System.out.println(obj);
        }

        System.out.println(" ===========================================================================");
        System.out.println("| ---- TESTE 3: ENCONTRAR TODOS VENDEDORES (findAll) ---- |");
        list = sellerDao.findAll();
        for (Seller obj : list){
            System.out.println(obj);
        }
    }
}
