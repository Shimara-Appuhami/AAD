const URL = "http://localhost:8080/api/v1/item";

$("#entityForm").submit(function (event) {
    event.preventDefault();
    saveData();
});

function saveData() {
    let entity = {
        id: $("#id").val(),
        name: $("#name").val(),
        qty: $("#qty").val(),
        price: $("#price").val(),
    };

    $.ajax({
        url: `${URL}/save`,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(entity),
        success: function () {
            alert("Item saved successfully!");
            getAll();
            clearForm();
        },
        error: function () {
            alert("Error saving Item!");
        }
    });
}
function getAll() {
    $.ajax({
        url: `${URL}/getAll`,
        type: "GET",
        dataType: "json",
        success: function (response) {
            console.log("Full Response:", response);

            let entities = Array.isArray(response) ? response : response.data;

            if (!Array.isArray(entities)) {
                console.error("Error: Expected an array but got", typeof entities);
                alert("Invalid response format from server!");
                return;
            }

            let tbody = $("#entityTableBody");
            tbody.empty();
            entities.forEach(entity => {
                let row = `
                    <tr>
                        <td>${entity.id}</td>
                        <td>${entity.name}</td>
                        <td>${entity.qty}</td>
                        <td>${entity.price}</td>
                        <td>
                            <button class="btn btn-sm btn-info" onclick="fillTextFields('${entity.id}', '${entity.name}', '${entity.qty}', '${entity.price}')">Edit</button>
                            <button class="btn btn-sm btn-danger" onclick="deleteEntity('${entity.id}')">Delete</button>
                        </td>
                    </tr>`;
                tbody.append(row);
            });
        },
        error: function (xhr, status, error) {
            console.error("Error fetching Items:", error);
            alert("Error fetching Items!");
        }
    });
}

function fillTextFields(id, name, qty, price) {
    $("#id").val(id);
    $("#name").val(name);
    $("#qty").val(qty);
    $("#price").val(price);

    selectedEntityId = id;

    $('#saveButton').hide();
    $('#updateButton').show();
    $('#deleteButton').show();
}

function updateEntity() {
    let updatedEntity = {
        id: selectedEntityId,
        name: $("#name").val(),
        qty: $("#qty").val(),
        price: $("#price").val(),

    };

    if (!updatedEntity.name || !updatedEntity.qty) {
        alert("Please fill all fields!");
        return;
    }

    $.ajax({
        url: `${URL}/update`,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(updatedEntity),
        success: function () {
            alert("Item updated successfully!");
            getAll();
            clearForm();
        },
        error: function () {
            alert("Error updating Item!");
        }
    });
}

function deleteEntity(id) {
    if (!confirm("Are you sure you want to delete this Item?")) return;

    $.ajax({
        url: `${URL}/delete/${id}`,
        type: "DELETE",
        success: function () {
            alert("Item deleted successfully!");
            getAll();
        },
        error: function () {
            alert("Error deleting Item!");
        }
    });
}

function clearForm() {
    $("#entityForm")[0].reset();
    $("#updateButton").hide();
    $("#deleteButton").hide();
}

$(document).ready(function () {
    getAll();
});
