document.addEventListener("DOMContentLoaded", function () {
  // Initial setup - show all items
  const menuItems = document.querySelectorAll(".menu-item-container");

  // Category filter functionality
  const categoryButtons = document.querySelectorAll(
    ".menu-categories .btn"
  );

  categoryButtons.forEach((button) => {
    button.addEventListener("click", function () {
      // Remove active class from all buttons
      categoryButtons.forEach((btn) => btn.classList.remove("active"));

      // Add active class to clicked button
      this.classList.add("active");

      // Get selected category
      const selectedCategory = this.getAttribute("data-category");

      // Filter items
      menuItems.forEach((item) => {
        const itemCategory = item.getAttribute("data-category");

        // Reset animation
        item.classList.remove("fade-in");

        // Filter logic
        if (
          selectedCategory === "semua" ||
          selectedCategory === itemCategory
        ) {
          // Show item with animation
          setTimeout(() => {
            item.style.display = "block";
            item.classList.add("fade-in");
          }, 10);
        } else {
          // Hide item
          item.style.display = "none";
        }
      });
    });
  });

  // Add to cart button hover effect
  const addButtons = document.querySelectorAll(".btn-tambah");

  addButtons.forEach((button) => {
    button.addEventListener("mouseenter", function () {
      this.innerHTML = '<i class="fas fa-cart-plus"></i> Tambah';
    });

    button.addEventListener("mouseleave", function () {
      this.innerHTML = '<i class="fas fa-cart-plus"></i> Tambah';
    });

    button.addEventListener("click", function () {
      const originalText = this.innerHTML;
      this.innerHTML = '<i class="fas fa-check"></i> Ditambahkan';

      setTimeout(() => {
        this.innerHTML = originalText;
      }, 1500);
    });
  });

  // Load more button functionality
  const loadMoreBtn = document.querySelector(".btn-load-more");

  loadMoreBtn.addEventListener("click", function () {
    this.innerHTML =
      '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> Loading...';

    setTimeout(() => {
      this.innerHTML = "Muat Lebih Banyak";
      alert("Tidak ada item tambahan untuk dimuat.");
    }, 1500);
  });
});