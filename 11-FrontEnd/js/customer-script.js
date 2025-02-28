const URL = "http://localhost:8080/10_BackEnd_Web_exploded/api/v1/customer";
let imageData = "";

function convertToBase64(event) {
    const file = event.target.files[0];
    if (file) {
        const reader = new FileReader();
        reader.onload = function (e) {
            imageData = e.target.result;
            $("#imagePreview").attr("src", imageData).show();
        };
        reader.readAsDataURL(file);
    }
}

$("#customerForm").submit(function (event) {
    event.preventDefault();
    saveData();
});

function saveData() {
    let customer = {
        id: $("#id").val(),
        name: $("#name").val(),
        address: $("#address").val(),
        image: imageData
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
        type: 'GET',
        success: function (customers) {
            let tbody = $('#customerTableBody');
            tbody.empty();
            customers.forEach(customer => {
                let row = `
                        <tr>
                            <td>${customer.id}</td>
                            <td>${customer.name}</td>
                            <td>${customer.address}</td>
                            <td><img src="${customer.image}" alt="Customer Image" style="max-width: 50px;"></td>
                            <td>
                                <button class="btn btn-sm btn-info" onclick="fillTextFields('${customer.id}', '${customer.name}', '${customer.address}', '${customer.image}')">Edit</button>
                                <button class="btn btn-sm btn-danger" onclick="deleteCustomer('${customer.id}')">Delete</button>
                            </td>
                        </tr>`;
                tbody.append(row);
            });
        },
        error: function () {
            alert('Error fetching customers!');
        }
    });
}
function fillTextFields(id, name, address, image) {
    $("#id").val(id);
    $("#name").val(name);
    $("#address").val(address);
    $("#imagePreview").attr("src", image).show();

    selectedCustomerId = id;

    $('#saveButton').hide();
    $('#updateButton').show();
    $('#deleteButton').show();
}

function updateCustomer() {
    let updatedCustomer = {
        id: selectedCustomerId,
        name: $("#name").val(),
        address: $("#address").val(),
        image: imageData
    };

    if (!updatedCustomer.name || !updatedCustomer.address) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: `${URL}/update`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedCustomer),
        success: function () {
            alert("Customer updated successfully!");
            getAll();
            imageData="";
            clearForm();

        },
        error: function () {
            alert("Error updating customer!");
        }
    });
}


function deleteCustomer(id) {
    if (!confirm('Are you sure you want to delete this customer?')) return;

    $.ajax({
        url: `${URL}/delete/${id}`,
        type: 'DELETE',
        success: function () {
            alert('Customer deleted successfully!');
            getAll();
        },
        error: function () {
            alert('Error deleting customer!');
        }
    });
}

function clearForm() {
    $('#customerForm')[0].reset();
    $('#imagePreview').hide();
    $('#updateButton').hide();
    $('#deleteButton').hide();
    imageData = "";
}

$(document).ready(function () {
    getAll();
});