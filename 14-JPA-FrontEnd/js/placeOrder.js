document.getElementById("orderForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let customerId = document.getElementById("customerId").value;
    let total = document.getElementById("total").value;
    let orderDetails = [];

    document.querySelectorAll(".orderDetail").forEach(detail => {
        let itemId = detail.querySelector(".itemId").value;
        let quantity = detail.querySelector(".quantity").value;
        let price = detail.querySelector(".price").value;

        orderDetails.push({ itemId, quantity, price, total: quantity * price });
    });

    let orderData = { customerId, total, orderDetails };

    fetch("http://localhost:8080/api/v1/order/place", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(orderData)
    })
        .then(response => response.json())
        .then(data => alert(data.message))
        .catch(error => console.error("Error:", error));
});

function addOrderDetail() {
    let container = document.getElementById("orderDetails");
    let newDetail = document.createElement("div");
    newDetail.classList.add("orderDetail");
    newDetail.innerHTML = `
        <label for="itemId">Item ID:</label>
        <input type="text" class="itemId" required>
        
        <label for="quantity">Quantity:</label>
        <input type="number" class="quantity" required>
        
        <label for="price">Price:</label>
        <input type="number" class="price" required>
    `;
    container.appendChild(newDetail);
}
