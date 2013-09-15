<!DOCTYPE html>
<html>
<head>
  <title>Play the NumberGuesser</title>
</head>
<body>

  <form id="start_game_form">
    <button title="Start Game!" id="start_game_button">Start Game!</button>
  </form>

<script src="http://code.jquery.com/jquery-1.10.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
  var gameUrl;

  $(function() {
    // add listener an new game button
    $('#start_game_button').on("click", function(event) {
      event.preventDefault();
      $.ajax({
        method: 'POST',
        url: '',
        dataType: 'json',
        success: function(data, status) {
          if (data.redirect) {
            gameUrl = data.redirect;
            $('#start_game_form').hide();
          }
        }
      });
    });
  });
</script>
</body>
</html>
