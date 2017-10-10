## Collections & Servlet/JSP

- Mô tả chung:

Sử dụng các đối tượng Collections phù hợp để xây dựng module FrontEnd web cung cấp thông tin tới khách hàng của doanh nghiệp với các dữ liệu được đề cập trong bài Ex07.

Bổ sung chức năng thực hiện "mua bảo hiểm" cho các ô tô.

Bổ sung chức năng hiển thị tin tức: danh sách  (có sắp xếp, phân trang) và chi tiết tin.

Xây dựng cơ chế caching cho việc QL tin tức (ko thường xuyên truy vấn DB nếu dữ liệu ko có thay đổi).

Như  vậy module FrontEnd web cần xây dựng gồm các trang sau:

Home: hiển thị danh mục tin tức, DS các tin hot, danh sách các ô tô đang chưa có bảo hiểm.

Link từ Home: hiển thị DS tất cả các tin, tất cả các ô tô (sắp xếp theo thứ tự tạo).

Có login, từ đó cho phép user mua bảo hiểm cho 1 ô tô cụ thể (có theo dõi lại).

Tin tức chi tiết