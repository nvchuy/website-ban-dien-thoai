function textAbstract(el, maxlength = 50, delimiter = " ") {
    let txt = $(el).text();
    if (el == null) {
        return "";
    }
    if (txt.length <= maxlength) {
        return txt;
    }
    let t = txt.substring(0, maxlength);
    let re = /\s+\S*$/;
    let m = re.exec(t);
    t = t.substring(0, m.index);
    return t + "...";
}

const maxlengthwanted = 100;

$('.pName').each(function (index, element) {
    $(element).text(textAbstract(element, maxlengthwanted, " "));
});

$('.product-name').each(function (index, element) {
    $(element).text(textAbstract(element, 50, " "));
});

let quantity = 0
let unit = 0
let id = 0

$(".subBtn").click(function () {
    quantity = parseInt($(this).parent().find('#pQuantity').val())

    unit = parseFloat($(this).parent().parent()
        .find('#unit_price').text().replaceAll(",", "").replaceAll("đ", ""))

    id = $(this).parent().parent().find('#pid').val()

    if (quantity - 1 < 1) {
        quantity = 1
    } else {
        quantity -= 1
        $(this).parent().find('#pQuantity').val(quantity)
        $(this).parent().parent().find('#total_price')
            .text((unit * quantity + "đ").toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,"))
    }

    $.ajax({
        url: `/store/cart/${id}/sub`,
        type: "get",
        success: function (d) {

        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        }
    });
})

$(".addBtn").click(function () {
    quantity = parseInt($(this).parent().find('#pQuantity').val())

    unit = parseFloat($(this).parent().parent()
        .find('#unit_price').text().replaceAll(",", "").replaceAll("đ", ""))

    id = $(this).parent().parent().find('#pid').val()

    quantity += 1

    $(this).parent().find('#pQuantity').val(quantity)
    $(this).parent().parent().find('#total_price')
        .text((unit * quantity + "đ").toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,"))

    $.ajax({
        url: `/store/cart/${id}/add`,
        type: "get",
        success: function () {

        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        }
    });
})

$(".pQuantity").on("change keydown paste input", function (e) {
    if ($(this).parent().find('#pQuantity').val().length < 2 && e.keyCode === 8) {
        e.preventDefault()
    }

    $(this).parent().find('#pQuantity').val().replace(/[^0-9\.]/g, '')

    quantity = parseInt($(this).parent().find('#pQuantity').val())

    $(this).parent().parent().find('#total_price')
        .text((unit * quantity + "đ").toString().replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,"))

    unit = parseFloat($(this).parent().parent()
        .find('#unit_price').text().replaceAll(",", "").replaceAll("đ", ""))

    id = $(this).parent().parent().find('#pid').val()

    $.ajax({
        url: `/store/cart/${id}/change`,
        type: "get",
        data: {"quantity": quantity},
        success: function () {

        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        }
    });
})

$('.btn-delete').click(function () {
    id = $(this).parent().parent().find('#pid').val()
    name = $(this).parent().parent().find('.pName').text()
    // console.log(name)
    let $this = $(this)

    $.ajax({
        url: `/delete/${id}`,
        type: "get",
        success: function () {
            $("#modal-dialog-remove-success").modal("show")
            setTimeout(() => {
                $("#modal-dialog-remove-success").modal("hide")
            }, 1500)
            $this.parent().parent().remove()

            $(".message").html("Xóa sản phẩm " + name + " thành công " +
                '<span style="color: limegreen"><i class="bi bi-check-circle"></i></span>')
            if ($('.pName').length === 0) {
                $("#checkOutBtn").hide()
            }
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        }
    });
})

let pid = 0

$('.btn-add2cart').click(function () {
    pid = $(this).parent().parent().parent().find('#pid-idx').val()

    $.ajax({
        url: `/add2cart/${pid}`,
        type: "get",
        success: function () {
            $("#modal-dialog-add2cart-success").modal("show")
            setTimeout(() => {
                $("#modal-dialog-add2cart-success").modal("hide")
            }, 1500)
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        }
    });
})

$('.btn-checkout').click(function () {
    $.ajax({
        url: `/store/cart/checkout`,
        type: "get",
        success: function () {
            $("#modal-dialog-checkout-success").modal("show")
            setTimeout(() => {
                $("#modal-dialog-checkout-success").modal("hide")
            }, 1500)
            setTimeout(() => {
                window.location = "/store"
            }, 1500)
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        },
    });
})

let order_id = 0
$('.row.order').click(function () {
    order_id = $(this).find(".order-id").text()
    console.log(order_id)

    $.ajax({
        url: `/store/order/${order_id}`,
        type: "get",
        success: function () {
            window.location = `/store/order/${order_id}`
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        },
    });
})

$(".return-order-page").click(function () {
    $.ajax({
        url: `/store/order`,
        type: "get",
        success: function () {
            window.location = `/store/order`
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        },
    });
})

let brand = null;

$(".btn-brand").click(function () {
    brand = $(this).parent().find(".btn-brand").text().toLowerCase()
    console.log(brand)

    $.ajax({
        url: `/store/filter/${brand}`,
        type: "get",
        success: function () {
            window.location = `/store/filter/${brand}`
        },
        error: function () {
            let errorCode = 404
            window.location = "/error/" + errorCode
        },
    });
})

$(".search-field").on("change keydown paste input", function () {
    console.log($(this).parent().parent().parent().parent().find(".search-field").val())

    $.ajax({
        url: `/search`,
        type: "get",
        data: {"search-value": $(this).parent().parent().parent().parent().find(".search-field").val()},
        success: function (response) {
        },
        error: function (response) {
        },
    });
})