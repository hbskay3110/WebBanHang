package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SanPhamDAO;
import model.SanPham;

/**
 * Servlet implementation class searchAjax
 */
@WebServlet("/searchAjax")
public class searchAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
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
		int pageSize = 1;
		int endPage =0;
		endPage = count/pageSize;
		if(count% pageSize !=0) {
			endPage ++;
		}
		List<SanPham> listSearch = spDAO.search(txtSearch, index,pageSize);
		PrintWriter out = response.getWriter();
		for (SanPham s : listSearch) {
			out.println("<div class=\"col l-2-4 m-4 c-6\">\r\n"
					+ "										<div class=\"home-product-wrap\">\r\n"
					+ "											<a class=\"home-produt-item\"\r\n"
					+ "												href=\"/WebsBanHang/product/productDetail?maSP=${i.maSP}\">\r\n"
					+ "												<div class=\"home-produt-item-img\"\r\n"
					+ "													style=\"background-image: url('./assets/img/product/${i.hinhAnh}');\">\r\n"
					+ "												</div>\r\n"
					+ "												<h4 class=\"home-produt-item-name\">${i.tenSP}</h4>\r\n"
					+ "												<div class=\"home-produt-item-price\">\r\n"
					+ "													<span class=\"home-produt-item-price-old\">${i.giaBanSP}.000đ</span>\r\n"
					+ "													<span class=\"home-produt-item-price-current\">${i.giaGiam}.000đ</span>\r\n"
					+ "												</div>\r\n"
					+ "											</a>\r\n"
					+ "											<div class=\"home-produt-item-action\">\r\n"
					+ "												<span class=\"home-produt-item-like \"> <i\r\n"
					+ "													class=\"home-produt-item-like-icon-empty far fa-heart\"></i>\r\n"
					+ "													<i class=\"home-produt-item-like-icon-fill fas fa-heart\"></i>\r\n"
					+ "												</span> <span class=\"home-produt-item-rating\"> <i\r\n"
					+ "													class=\"home-produt-item__start-gold fas fa-star\"></i> <i\r\n"
					+ "													class=\"home-produt-item__start-gold fas fa-star\"></i> <i\r\n"
					+ "													class=\"home-produt-item__start-gold fas fa-star\"></i> <i\r\n"
					+ "													class=\"home-produt-item__start-gold fas fa-star\"></i> <i\r\n"
					+ "													class=\"fas fa-star\"></i>\r\n"
					+ "												</span> <span class=\"home-produt-item__sold\">${i.soLuongBan}\r\n"
					+ "													đã bán</span>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"home-produt-item__origin\">\r\n"
					+ "												<span class=\"home-produt-item__brand\"></span> <span\r\n"
					+ "													class=\"home-produt-item__origin-name\"></span>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"home-produt-item__favourite\">\r\n"
					+ "												<i class=\"fas fa-check\"></i><span>Yêu thích</span>\r\n"
					+ "											</div>\r\n"
					+ "											<div class=\"home-produt-item__sale-off\">\r\n"
					+ "												<span class=\"home-produt-item__sale-off-percent\">${i.sale}\r\n"
					+ "													%</span> <span class=\"home-produt-item__sale-off-label\">Giảm</span>\r\n"
					+ "											</div>\r\n"
					+ "											<button class=\"btn btn-primary btn-add-product\">Thêm\r\n"
					+ "												vào giỏ hàng</button>\r\n"
					+ "										</div>\r\n"
					+ "									</div>");
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
