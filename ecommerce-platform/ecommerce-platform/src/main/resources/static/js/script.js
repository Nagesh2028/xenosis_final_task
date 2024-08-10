document.addEventListener('DOMContentLoaded', () => {
    fetch('/api/products')
        .then(response => response.json())
        .then(products => {
            const productSection = document.getElementById('products');
            products.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.className = 'product-item';
                productDiv.innerHTML = `
                    <h2>${product.name}</h2>
                    <img src="${product.imageUrl}" alt="${product.name}">
                    <p>${product.description}</p>
                    <p>Price: $${product.price}</p>
                    <button>Add to Cart</button>
                `;
                productSection.appendChild(productDiv);
            });
        });
});
const cart = [];

document.addEventListener('DOMContentLoaded', () => {
    fetch('/api/products')
        .then(response => response.json())
        .then(products => {
            const productSection = document.getElementById('products');
            products.forEach(product => {
                const productDiv = document.createElement('div');
                productDiv.className = 'product-item';
                productDiv.innerHTML = `
                    <h2>${product.name}</h2>
                    <img src="${product.imageUrl}" alt="${product.name}">
                    <p>${product.description}</p>
                    <p>Price: $${product.price}</p>
                    <button onclick="addToCart(${product.id})">Add to Cart</button>
                `;
                productSection.appendChild(productDiv);
            });
        });
});

function addToCart(productId) {
    fetch(`/api/products/${productId}`)
        .then(response => response.json())
        .then(product => {
            const existingProduct = cart.find(p => p.id === product.id);
            if (existingProduct) {
                existingProduct.quantity++;
            } else {
                cart.push({ ...product, quantity: 1 });
            }
            updateCartUI();
        });
}

function updateCartUI() {
    const cartSection = document.getElementById('cart-items');
    cartSection.innerHTML = '';
    cart.forEach(item => {
        const cartItemDiv = document.createElement('div');
        cartItemDiv.className = 'cart-item';
        cartItemDiv.innerHTML = `
            <h2>${item.name}</h2>
            <p>Quantity: ${item.quantity}</p>
            <p>Price: $${item.price * item.quantity}</p>
        `;
        cartSection.appendChild(cartItemDiv);
    });
}
function placeOrder() {
    fetch('/api/orders', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            user: { id: 1 }, // Replace with actual user id
            orderDate: new Date(),
            totalAmount: cart.reduce((sum, item) => sum + (item.price * item.quantity), 0),
            orderItems: cart.map(item => ({
                product: { id: item.id },
                quantity: item.quantity,
                price: item.price
            }))
        })
    })
    .then(response => response.json())
    .then(order => {
        alert('Order placed successfully!');
        cart.length = 0;
        updateCartUI();
    });
}
