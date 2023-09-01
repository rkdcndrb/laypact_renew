$(function() {

  device_check();

  gnb_motion();
  ham_motion();
  footer_motion();

  project_motion();
  project_item_motion();
  qna_motion();

  if ($('footer').length > 0) {
    slogan_logo_motion();
  }

  if ($('#main-svg-wrap').length > 0) {
    main_slogan_logo_motion();
  }

  ScrollSmoother.create({
    smooth: 1,
    effects: true,
    // smoothTouch: 0.1,
  });

  setTimeout(function() {
    $('body,html').addClass('on');
  }, 100)

  var mouseX = window.innerWidth / 2,
      mouseY = window.innerHeight / 2,
      mouseX2 = window.innerWidth / 2,
      mouseY2 = window.innerHeight / 2,
      mouseX3 = window.innerWidth / 2,
      mouseY3 = window.innerHeight / 2;

  document.onmousemove = function(e) {
    e = e || window.event;
    mouseX = e.clientX;
    mouseY = e.clientY;
    mouseX2 = e.clientX;
    mouseY2 = e.clientY;
    mouseX3 = e.clientX;
    mouseY3 = e.clientY;
  }

  // cursor
  var $cursor = $('#cursor');

  var posX = 0,
    posY = 0;

  var mouseX = 0,
    mouseY = 0;

  TweenMax.to({}, 0.016, {
    repeat: -1,
    onRepeat: function() {
      posX += (mouseX - posX) / 9;
      posY += (mouseY - posY) / 9;

      TweenMax.set(cursor, {
        css: {
          left: mouseX,
          top: mouseY
        }
      });
    }
  });

  $('[data-hover]').hover(function() {
    $('.cursor').addClass('on');
    var msg = $(this).data('hover-msg');
    $('.cursor span').html(msg);
    // if($(this).is('[data-hover-img]') == true) {
    //   var src = $(this).data('hover-img');
    //   $('.cursor .img').html('<img src="'+src+'">');
    // } else {
    //   $('.cursor .img').empty();
    // }
  }, function() {
    $('.cursor').removeClass('on');
  });

  $('.ham-btn').hover(function() {
    $('.cursor').addClass('on');
    if ($(this).parent('header').hasClass('open') == true) {
      $('.cursor span').html('Close menu');
    } else {
      $('.cursor span').html('View menu');
    }
  }, function() {
    $('.cursor').removeClass('on');
  });

  $('.qa-btn').hover(function() {
    $('.cursor').addClass('on');
    if ($(this).parent('.qa-item').hasClass('open') == true) {
      $('.cursor span').html('Close');
    } else {
      $('.cursor span').html('Open');
    }
  }, function() {
    $('.cursor').removeClass('on');
  });

  $('.goto a').hover(function() {
    $('.cursor').addClass('on');
    if ($('body').hasClass('bottom') == true) {
      $('.cursor span').html('Go to Top');
    } else {
      $('.cursor span').html('Go to Contact');
    }
  }, function() {
    $('.cursor').removeClass('on');
  });

  $('[data-hover-svg]').hover(function() {
    $('.cursor').addClass('action');
  }, function() {
    $('.cursor').removeClass('action');
  });

  // fade up motion
  const fdElementList = document.querySelectorAll('.fade');

  const fdFunc = function() {
    for (const element of fdElementList) {
      if (!element.classList.contains('show')) {
        if (window.innerHeight > element.getBoundingClientRect().top + 80) {
          element.classList.add('show');
        }
      }
    }
  }

  fdFunc();

  // project list set
  $('.project-num').each(function() {
    // year
    var today = new Date();
    var year = today.getFullYear();
    $(this).find('.year').html('2004  -  ' + year);

    // total
    var num = $(this).parents('.content').find('.project-wrap').find('li').length;
    $(this).find('.total').html(num);
  })

  // qna toggle motion
  $('.qa-btn').on('click', function() {
    $(this).parent('.qa-item').toggleClass('open');
    $(this).siblings('.qa-content').stop().slideToggle({
      start: function() {
        $(this).css('display', 'flex');
      }
    });
    if ($(this).parent('.qa-item').hasClass('open') == true) {
      $('.cursor span').html('Close');
    } else {
      $('.cursor span').html('Open');
    }
  });

  // qna item action
  const qa_items = gsap.utils.toArray('.qa-item');
  qa_items.forEach((qa_item) => {
    gsap.from(qa_item, {
      scrollTrigger: {
        start: 'top center',
        end: 'bottom center',
        trigger: qa_item,
        toggleClass: 'is-act',
        // markers: true,
      },
    });
  });

  // footer goto button
  $('.goto a').on('click', function(e) {
    if ($('body').hasClass('bottom') == true) {
      e.preventDefault();
      $('html, body').animate({
        scrollTop: 0
      });
    } else {
      $(this).attr('href', 'https://www.naver.com/');
      return;
    }
  })

  $(window).on('scroll', function() {
    setTimeout(function() {
      fdFunc();
    },200)
    gnb_motion();
    footer_motion();
  })

  $(window).on('resize', function() {
    device_check();
    fdFunc();
    project_motion();
    qna_motion();
    setTimeout(function() {
      ScrollTrigger.refresh();
    },100)
  })

  // --------------- function --------------------

  function device_check() {
    function is_touch_enabled() {
      return ('ontouchstart' in window) || (navigator.maxTouchPoints > 0) || (navigator.msMaxTouchPoints > 0);
    }
    if (is_touch_enabled()) {
      $('html').addClass('is-touch-device');
      $('html').removeClass('is-untouch-device');
    } else {
      $('html').removeClass('is-touch-device');
      $('html').addClass('is-untouch-device');
    }
  }

  function slogan_logo_motion() {
    const mouseCircleEl = document.getElementById('svg-circle');
    const mouseCircle = mouseCircleEl.querySelector('circle');
    const svgTitle = document.getElementById('svg-title');
    const svgText = document.getElementById('svg-logo');
    const svgTitleViewBox = svgTitle.getAttribute('viewBox');
    const stViewBoxValue = svgTitleViewBox.split(/\s+|,/);
    const stViewBoxWidth = stViewBoxValue[2];
    const stViewBoxHeight = stViewBoxValue[3];

    var circle = {
      el: mouseCircleEl,
      x: mouseCircleEl.getAttribute('cx'),
      y: mouseCircleEl.getAttribute('cy'),
      update: function() {
        l = this.x;
        t = this.y;

        mouseCircle.setAttribute('cx', l);
        mouseCircle.setAttribute('cy', t);
      }
    }

    setInterval(move, 0)

    function move() {
      const rect = svgText.getBoundingClientRect();
      const scale = stViewBoxWidth / rect.width;
      circlePosX = (mouseX2 - rect.left) * scale;
      circlePosY = (mouseY2 - rect.top) * scale;

      circle.x = lerp(circle.x, circlePosX, 0.1);
      circle.y = lerp(circle.y, circlePosY, 0.1);
      circle.update()
    }

    function lerp(start, end, amt) {
      return (1 - amt) * start + amt * end
    }
  }

  function main_slogan_logo_motion() {
    const mouseCircleEl = document.getElementById('main-svg-circle');
    const mouseCircle = mouseCircleEl.querySelector('circle');
    const svgTitle = document.getElementById('main-svg-title');
    const svgText = document.getElementById('main-svg-logo');
    const svgTitleViewBox = svgTitle.getAttribute('viewBox');
    const stViewBoxValue = svgTitleViewBox.split(/\s+|,/);
    const stViewBoxWidth = stViewBoxValue[2];
    const stViewBoxHeight = stViewBoxValue[3];

    var circle = {
      el: mouseCircleEl,
      x: mouseCircleEl.getAttribute('cx'),
      y: mouseCircleEl.getAttribute('cy'),
      update: function() {
        l = this.x;
        t = this.y;

        mouseCircle.setAttribute('cx', l);
        mouseCircle.setAttribute('cy', t);
      }
    }

    setInterval(move2, 0)

    function move2() {
      const rect = svgText.getBoundingClientRect();
      const scale = stViewBoxWidth / rect.width;
      circlePosX = (mouseX3 - rect.left) * scale;
      circlePosY = (mouseY3 - rect.top) * scale;

      circle.x = lerp(circle.x, circlePosX, 0.1);
      circle.y = lerp(circle.y, circlePosY, 0.1);
      circle.update()
    }

    function lerp(start, end, amt) {
      return (1 - amt) * start + amt * end
    }
  }

  function gnb_motion() {
    if ($(window).scrollTop() >= 50) {
      $('header').addClass('down');
      $('header').removeClass('top');
    } else {
      $('header').removeClass('down');
      $('header').addClass('top');
    }
  }

  // mobile hambuger button
  function ham_motion() {
    $('html').removeClass('hidden');

    $('.ham-btn').on('click', function() {
      $('header').toggleClass('open');
      if ($('header').hasClass('open') == true) {
        $('html').addClass('hidden');
        $('.cursor span').html('Close menu');
      } else {
        $('html').removeClass('hidden');
        $('.cursor span').html('View menu');
      }
    });

    $(window).on('resize', function() {
      $('html').removeClass('hidden');
      $('header').removeClass('open');
    })
  }

  function footer_motion() {
    if($(window).width() > 1024) {
      if ($(window).scrollTop() + $(window).height() + 1 > $(document).height()) {
        $('body').addClass('bottom');
      } else {
        $('body').removeClass('bottom');
      }
    } else {
      $('body').addClass('bottom');
    }
  }

  function project_motion() {
    // list view
    $('.project-list.sm li').slice(0, 20).show();
    $('.view-more').on('click', function() {
      $(this).parent('.btn-wrap').siblings('.project-wrap').find('li:hidden').slice(0, 12).show(function() {
        setTimeout(function() {

          fdFunc();
        },200)
        ScrollTrigger.killAll();
        project_item_motion();
      }).removeClass('show');
      setTimeout(function() {
        if ($('.btn-wrap').siblings('.project-wrap').find('li:hidden').length == 0) {
          $('.btn-wrap').hide();
        }
      },200)
    });
  }

  function project_item_motion() {
    const pj_items = gsap.utils.toArray('.project-item');
    pj_items.forEach((pj_item) => {
      let r = pj_item.querySelector('.sub-hidden');
      let a = gsap.to(r, {
        width: 'auto',
        duration: .5,
        paused: !0,
      });
      gsap.from(pj_item, {
        scrollTrigger: {
          start: 'top center',
          end: '80% center',
          trigger: pj_item,
          toggleClass: 'is-act',
          // markers: true,
          onEnter() {a.play()},
          onLeave() {a.reverse()},
          onEnterBack() {a.play()},
          onLeaveBack() {a.reverse()},
        },
      });
    });
  }

  function qna_motion() {
    // -- icon move motion
    $('.qa-btn').each(function() {
      var w = $(this).width() - $(this).find('p').width() - 90;
      $(this).find('.ico').css('left', w);
    });
  }

})
