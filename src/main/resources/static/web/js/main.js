$(function() {

  // if($(window).scrollTop() <= 10){
    setTimeout(function() {
      $('html').addClass('start');
    }, 200)
  // }

  // hi label motion
  gsap.to('.hi', {
    scrollTrigger: {
      trigger: '.main02',
      start: 'top center',
      endTrigger: '.main03',
      end: 'top top',
      // markers: true,
      onEnter: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(0)')
      },
      onEnterBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(0)')
      },
      onLeaveBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(100%)')
      },
    }
  });
  gsap.to('.hi', {
    scrollTrigger: {
      trigger: '.main03',
      start: 'top center',
      endTrigger: '.main04',
      end: 'top top',
      // markers: true,
      onEnter: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-100%)')
      },
      onEnterBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-100%)')
      },
      onLeaveBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(0)')
      },
    }
  });
  gsap.to('.hi', {
    scrollTrigger: {
      trigger: '.main04',
      start: 'top center',
      endTrigger: '.main04',
      end: 'bottom top',
      // markers: true,
      onEnter: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-200%)')
      },
      onEnterBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-200%)')
      },
      onLeaveBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-100%)')
      },
    }
  });
  gsap.to('.hi', {
    scrollTrigger: {
      trigger: '.main04',
      start: 'bottom center',
      end: 'bottom bottom',
      // markers: true,
      onEnter: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-300%)')
      },
      onEnterBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-300%)')
      },
      onLeaveBack: function() {
        $('.hi .sub-hi span').css('transform', 'translateY(-200%)')
      },
    }
  });

})
