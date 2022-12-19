package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChiTietSanPhamDAO;
import dao.SanPhamDAO;
import model.SanPham;

/**
 * Servlet implementation class SearchSP
 */
@WebServlet("/SearchSP")
public class SearchSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchSP() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String attribute = request.getParameter("attribute");
		System.out.println(attribute);
		if(attribute == null) {
			attribute = "searchTxt";
		}
		ChiTietSanPhamDAO ct_spDAO = new ChiTietSanPhamDAO();
		List<String> listLoai = ct_spDAO.listLoaiSP();
		request.setAttribute("listLoai", listLoai);
		if(attribute.equals("searchTxt")) {
			try {
				String txtSearch = request.getParameter("txtSearch");
				String indexString = request.getParameter("index");
				System.out.println(indexString);
				if(indexString==null) {
					indexString ="1";
				}
				int index= Integer.parseInt(indexString);
				System.out.println(txtSearch);
				SanPhamDAO spDAO = new SanPhamDAO();
				int count = spDAO.countSP(txtSearch);
				int pageSize = 9;
				int endPage =0;
				endPage = count/pageSize;
				if(count% pageSize !=0 && count> pageSize) {
					endPage ++;
				}
				if(endPage==0) {
					endPage=1;
				}
				List<SanPham> listSearch = spDAO.search(txtSearch, index,pageSize);
				request.setAttribute("list", listSearch);
				request.setAttribute("endPage", endPage);
				request.setAttribute("txtSearch", txtSearch);
				request.setAttribute("index", index);
				request.getRequestDispatcher("/SearchProduct.jsp").forward(request, response);
				System.out.println(count);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			try {
				String txtSearch = request.getParameter("txtSearch");
				String proviso = request.getParameter("proviso");
				String loaiSP =  request.getParameter("loaiSP");
				String indexString = request.getParameter("index");			
				if(indexString==null) {
					indexString ="1";
				}
				System.out.println(indexString);
				int index= Integer.parseInt(indexString);
				int pageSize = 5;
				SanPhamDAO spDAO = new SanPhamDAO();
				List<SanPham> listSearch = spDAO.searchByAttribute(index, pageSize, proviso, attribute,txtSearch,loaiSP);
				System.out.println(listSearch.size());
				int count = new ChiTietSanPhamDAO().tongLoai(loaiSP);
				System.out.println(count);
				int endPage =0;
				endPage = count/pageSize;
				if(count% pageSize !=0 && count> pageSize) {
					endPage ++;
				}
				if(endPage==0) {
					endPage=1;
				}
				request.setAttribute("loaiSP", loaiSP);
				request.setAttribute("list", listSearch);
				request.setAttribute("endPage", endPage);
				request.setAttribute("index", index);
				request.setAttribute("attribute", attribute);
				request.setAttribute("proviso", proviso);
				request.setAttribute("txtSearch", txtSearch);
				request.getRequestDispatcher("/SearchProduct.jsp").forward(request, response);
			} catch (Exception e) {
				e.getMessage();
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
