package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SellerDAO sellerDao = DaoFactory.createSellerDao();
        DepartmentDAO departmentDao = DaoFactory.createDepartmentDao();

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

        System.out.println(" ===========================================================================");
        System.out.println("| ---- TESTE 4: INSERCAO DE VENDEDORES (insert) ---- |");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserido, novo ID: " + newSeller.getId());

        System.out.println(" ===========================================================================");
        System.out.println("| ---- TESTE 5: ATUALIZAR INFORMACOES DOS VENDEDORES (update) ---- |");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completo");

        System.out.println(" ===========================================================================");
        System.out.println("| ---- TESTE 6: DELETAR VENDEDORES DO BANCO (delete) ---- |");
        System.out.print("Entre com o id do vendedor a ser deletado: ");
        int idSeller = sc.nextInt();
        sellerDao.deleteById(idSeller);
        System.out.println("Delete completo");

        sc.close();
    }
}
