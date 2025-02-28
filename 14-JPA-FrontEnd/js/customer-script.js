const URL = "http://localhost:8080/api/v1/customer";
let selectedCustomerId = null;

$("#customerForm").submit(function (event) {
    event.preventDefault();
    if (selectedCustomerId) {
        updateCustomer();
    } else {
        saveData();
    }
});

function saveData() {
    let customer = {
        id: $("#id").val(),
        name: $("#name").val(),
        address: $("#address").val()
    };

    $.ajax({
        url: `${URL}/save`,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(customer),
        success: function () {
            alert("Customer saved successfully!");
            getAll();
            clearForm();
        },
        error: function () {
            alert("Error saving customer!");
        }
    });
}
function getAll() {
    $.ajax({
        url: `${URL}/getAll`,
        type: "GET",
        dataType: "json", // Ensures response is parsed as JSON
        success: function (response) {
            console.log("Full Response:", response);

            // Check if the response contains a data field (if using ResponseUtil)
            let customers = Array.isArray(response) ? response : response.data;

            if (!Array.isArray(customers)) {
                console.error("Error: Expected array, got", typeof customers);
                return;
            }

            // Render the table
            $("#customerTableBody").empty();
            customers.forEach(customer => {
                $("#customerTableBody").append(`
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.address}</td>
                    <td>
                        <button class="btn btn-sm btn-info" onclick="fillTextFields('${customer.id}', '${customer.name}', '${customer.address}')">Edit</button>
                        <button class="btn btn-sm btn-danger" onclick="deleteCustomer('${customer.id}')">Delete</button>
                    </td>
                </tr>`);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching customers:", error);
            alert("Error fetching customers!");
        }
    });
}


function fillTextFields(id, name, address) {
    $("#id").val(id);
    $("#name").val(name);
    $("#address").val(address);

    selectedCustomerId = id;

    $("#saveButton").hide();
    $("#updateButton").show();
    $("#deleteButton").show();
}

function updateCustomer() {
    let updatedCustomer = {
        id: selectedCustomerId,
        name: $("#name").val(),
        address: $("#address").val()
    };

    if (!updatedCustomer.name || !updatedCustomer.address) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: `${URL}/update`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(updatedCustomer),
        success: function () {
            alert("Customer updated successfully!");
            getAll();
            clearForm();
        },
        error: function () {
            alert("Error updating customer!");
        }
    });
}

function deleteCustomer(id) {
    if (!confirm("Are you sure you want to delete this customer?")) return;

    $.ajax({
        url: `${URL}/delete/${id}`,
        type: "DELETE",
        success: function () {
            alert("Customer deleted successfully!");
            getAll();
            clearForm();
        },
        error: function () {
            alert("Error deleting customer!");
        }
    });
}

function clearForm() {
    $("#customerForm")[0].reset();
    $("#updateButton").hide();
    $("#deleteButton").hide();
    $("#saveButton").show();
    selectedCustomerId = null;
}

$(document).ready(function () {
    getAll();
});
